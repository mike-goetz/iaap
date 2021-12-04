package ch.mike.goetz.iaap.server.model.repository;

import ch.mike.goetz.iaap.server.model.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository
    extends AttributeRepository<Permission.Localization, Permission> {}
