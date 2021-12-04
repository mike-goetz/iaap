package ch.mike.goetz.iaap.server.model.service;

import org.springframework.stereotype.Service;

@Service
public class AttributeService {

  private final AttributeStatusService attributeStatusService;
  private final AppLanguageService appLanguageService;
  private final GenderService genderService;
  private final PermissionService permissionService;
  private final RoleService roleService;

  public AttributeService(
      AttributeStatusService attributeStatusService,
      AppLanguageService appLanguageService,
      GenderService genderService,
      PermissionService permissionService,
      RoleService roleService) {
    this.attributeStatusService = attributeStatusService;
    this.appLanguageService = appLanguageService;
    this.genderService = genderService;
    this.permissionService = permissionService;
    this.roleService = roleService;
  }

  public AttributeStatusService getAttributeStatusService() {
    return attributeStatusService;
  }

  public AppLanguageService getAppLanguageService() {
    return appLanguageService;
  }

  public GenderService getGenderService() {
    return genderService;
  }

  public PermissionService getPermissionService() {
    return permissionService;
  }

  public RoleService getRoleService() {
    return roleService;
  }
}
