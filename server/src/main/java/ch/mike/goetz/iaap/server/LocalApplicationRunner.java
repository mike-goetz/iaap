package ch.mike.goetz.iaap.server;

import ch.mike.goetz.iaap.server.helper.AttributeImport;
import ch.mike.goetz.iaap.server.model.AbstractLocalization;
import ch.mike.goetz.iaap.server.model.AppLanguage;
import ch.mike.goetz.iaap.server.model.Attribute;
import ch.mike.goetz.iaap.server.model.AttributeType;
import ch.mike.goetz.iaap.server.model.AttributeTypeSetup;
import ch.mike.goetz.iaap.server.model.Gender;
import ch.mike.goetz.iaap.server.model.Permission;
import ch.mike.goetz.iaap.server.model.Role;
import ch.mike.goetz.iaap.server.model.User;
import ch.mike.goetz.iaap.server.model.repository.AttributeTypeRepository;
import ch.mike.goetz.iaap.server.model.repository.AttributeTypeSetupRepository;
import ch.mike.goetz.iaap.server.model.service.AbstractAttributeService;
import ch.mike.goetz.iaap.server.model.service.AttributeService;
import ch.mike.goetz.iaap.server.model.service.SecurityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class LocalApplicationRunner implements ApplicationRunner {

  private static final Logger logger = LoggerFactory.getLogger(LocalApplicationRunner.class);

  @Autowired
  private PlatformTransactionManager txManager;
  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private ApplicationCache applicationCache;
  @Autowired
  private MasterdataImportProperty importProperty;
  @Autowired
  private AttributeTypeRepository attributeTypeRepository;
  @Autowired
  private AttributeTypeSetupRepository attributeTypeSetupRepository;
  @Autowired
  private SecurityService securityService;
  @Autowired
  private AttributeService attributeService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    TransactionTemplate tx = new TransactionTemplate(txManager);
    tx.execute(status -> {
      createAttributes();
      createUsers();
      return null;
    });
  }

  private void createAttributes() {
    createAttributes(AppLanguage.class, AppLanguage.Localization.class, attributeService.getAppLanguageService(), "appLanguage", getLockedSetup(), false, null);
    createAttributes(Gender.class, Gender.Localization.class, attributeService.getGenderService(), "gender", getDefaultSetup(), false, null);

    createAttributes(Permission.class, Permission.Localization.class, attributeService.getPermissionService(), "permission", getLockedSetup(), false, null);
    createAttributes(Role.class, Role.Localization.class, attributeService.getRoleService(), "role", getLockedSetup(), false, this::fetchAndReplaceRelations);

  }

  private AttributeTypeSetup getLockedSetup() {
    return AttributeTypeSetup.builder().sortable(true).deleteable(false).editable(true).extendable(false).hideable(false).build();
  }

  private AttributeTypeSetup getDefaultSetup() {
    return AttributeTypeSetup.builder().sortable(true).deleteable(true).editable(true).extendable(true).hideable(true).build();
  }

  private void fetchAndReplaceRelations(List<Role> roles) {
    if (CollectionUtils.isEmpty(roles)) {
      return;
    }
    roles.forEach(role -> {
      var rolePermissions = role.getPermissions();
      if (CollectionUtils.isEmpty(rolePermissions)) {
        return;
      }
      var permissions = rolePermissions.stream().map(key -> applicationCache.getPermission(key.getId()))
          .filter(Optional::isPresent)
          .map(Optional::get)
          .collect(Collectors.toSet());
      role.setPermissions(permissions);
    });
  }

  private <L extends AbstractLocalization, T extends Attribute<L>> void createAttributes(Class<T> type, Class<L> localization, AbstractAttributeService<L, T> service, String importId,
      AttributeTypeSetup attributeTypeSetup, boolean sort, Consumer<List<T>> callback) {
    if (service.count() == 0) {
      Resource importFile = importProperty.getFiles().get(importId);
      logger.info("Create \"{}\" Records", StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(type.getSimpleName()), " "));
      List<T> items = importAttributeTypeAndGetItemsToPersist(importFile, type, localization, attributeTypeSetup, sort);
      if (callback != null) {
        callback.accept(items);
      }
      service.save(items);
      logger.info("  -> {} Records imported", items.size());
    }
  }

  private <L extends AbstractLocalization, T extends Attribute<L>> List<T> importAttributeTypeAndGetItemsToPersist(Resource resource, Class<? super T> importType, Class<? super L> localizationType,
      AttributeTypeSetup attributeTypeSetup, boolean sort) {
    try {
      var type = objectMapper.getTypeFactory().constructParametricType(AttributeImport.class, localizationType, importType);
      AttributeImport<L, T> importer = objectMapper.readValue(resource.getInputStream(), type);
      var importerAttributeType = importer.getAttributeType();
      var identifier = importerAttributeType.getId();
      if (identifier == null) {
        throw new IllegalArgumentException("id can't be null");
      }
      var persistedAttributeType = attributeTypeRepository.findById(identifier).orElse(null);
      final AttributeType attributeType;
      if (persistedAttributeType == null) {
        attributeType = attributeTypeRepository.save(importerAttributeType);
        createAttributeTypeSetup(attributeType, attributeTypeSetup);
      } else {
        persistedAttributeType.getLocalizations().clear();
        persistedAttributeType.getLocalizations().addAll(importerAttributeType.getLocalizations());
        attributeType = attributeTypeRepository.save(persistedAttributeType);
      }
      var attributes = importer.getAttributes();
      attributes.forEach(a -> a.setAttributeType(attributeType));

      if (sort) {
        return attributes.stream()
            .sorted((a1, a2) -> StringUtils.compare(a1.getId(), a2.getId()))
            .toList();
      } else {
        return new ArrayList<>(attributes);
      }
    } catch (IOException e) {
      logger.error("Failed to load import file {} for {}", resource.getFilename(), importType.getSimpleName());
      return Collections.emptyList();
    }
  }

  private void createAttributeTypeSetup(AttributeType attributeType, AttributeTypeSetup attributeTypeSetup) {
    if (attributeType != null && attributeType.getId() != null && attributeTypeSetupRepository.findById(attributeType.getId()).isEmpty()) {
      logger.info("Create Attribute Type Setup for {}", attributeType.getId());
      attributeTypeSetup.setId(attributeType.getId());
      attributeTypeSetupRepository.save(attributeTypeSetup);
    }
  }

  private void createUsers() {
    if (securityService.countUsers() == 1) {
      logger.info("Create initial Users");

      try {
        CollectionLikeType type = objectMapper.getTypeFactory().constructCollectionLikeType(ArrayList.class, User.class);
        List<User> users = objectMapper.readValue(importProperty.getFiles().get("user").getInputStream(), type);
        if (CollectionUtils.isEmpty(users)) {
          return;
        }
        logger.info("  -> Create References between Users and Roles");
        for (User user : users) {
          if (user.getContact() != null && user.getContact().getGender() != null) {
            user.getContact().setGender(applicationCache.getGender(user.getContact().getGender().getId()).orElse(null));
          }
          var userRoles = user.getRoles();
          if (CollectionUtils.isNotEmpty(userRoles)) {
            var roles = userRoles.stream().map(role -> applicationCache.getRole(role.getId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
            user.setRoles(roles);
          }
          user.setPassword(passwordEncoder.encode("test"));
        }
        logger.info("  -> Save {} User Records", users.size());
        securityService.saveUsers(users);
      } catch (IOException e) {
        logger.error("Failed to load import file for Users");
      }
    }
  }
}
