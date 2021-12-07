package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.Permission;
import ch.mike.goetz.iaap.server.model.Role;
import ch.mike.goetz.iaap.server.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityService {

  private final RoleService roleService;
  private final PermissionService permissionService;
  private final UserService userService;

  public long countRoles() {
    return roleService.count();
  }

  public Role saveRole(Role role) {
    return roleService.save(role);
  }

  public void saveRoles(Iterable<Role> roles) {
    roleService.save(roles);
  }

  public long countPermissions() {
    return permissionService.count();
  }

  public Permission savePermission(Permission permission) {
    return permissionService.save(permission);
  }

  public void savePermissions(Iterable<Permission> permissions) {
    permissionService.save(permissions);
  }

  public long countUsers() {
    return userService.count();
  }

  public User saveUser(User user) {
    return userService.save(user);
  }

  public void saveUsers(Iterable<User> users) {
    userService.save(users);
  }

  public Optional<Role> findRoleById(String name) {
    return roleService.findById(name);
  }

  public Optional<Permission> findPermissionById(String name) {
    return permissionService.findById(name);
  }
}
