package ch.mike.goetz.iaap.server.model.repository;

import ch.mike.goetz.iaap.server.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ch.mike.goetz.iaap.server.model.repository.AttributeRepository<Role.Localization, Role> {

}
