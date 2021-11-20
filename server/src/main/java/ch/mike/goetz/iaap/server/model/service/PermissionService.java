package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.Permission;
import ch.mike.goetz.iaap.server.model.repository.PermissionRepository;
import org.springframework.stereotype.Service;

@Service
public class PermissionService extends AbstractAttributeService<Permission.Localization, Permission> {

  public PermissionService(PermissionRepository permissionRepository) {
    super(permissionRepository);
  }

}
