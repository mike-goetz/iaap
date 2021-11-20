package ch.mike.goetz.iaap.server.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeService {

  // @formatter:off
    @Autowired private AppLanguageService appLanguageService;
    @Autowired private GenderService genderService;
    @Autowired private PermissionService permissionService;
    @Autowired private RoleService roleService;
    // @formatter:on

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
