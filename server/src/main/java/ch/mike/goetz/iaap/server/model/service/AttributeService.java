package ch.mike.goetz.iaap.server.model.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class AttributeService {

  private final AttributeStatusService attributeStatusService;
  private final AppLanguageService appLanguageService;
  private final GenderService genderService;
  private final PermissionService permissionService;
  private final RoleService roleService;
}
