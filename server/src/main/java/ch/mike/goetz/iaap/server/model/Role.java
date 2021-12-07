package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.model.Role.Localization;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "app_role")
public class Role extends Attribute<Localization> {

  @SuperBuilder
  @Getter
  @Setter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @Entity
  @Table(name = "app_role_l10n")
  public static class Localization extends AbstractLocalization {}

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "app_role_permissions",
      joinColumns = @JoinColumn(name = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "permission_id"))
  private Set<Permission> permissions;
}
