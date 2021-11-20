package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.Role;
import ch.mike.goetz.iaap.server.model.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractAttributeService<Role.Localization, Role> {

  public RoleService(RoleRepository roleRepository) {
    super(roleRepository);
  }

}
