package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.model.Role.Localization;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@FieldNameConstants
@Entity
@Table(name = "app_role")
public class Role extends Attribute<Localization> {

  @Entity
  @Table(name = "app_role_l10n")
  public static class Localization extends AbstractLocalization {

  }

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "app_role_permissions",
      joinColumns = @JoinColumn(name = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "permission_id"))
  private Set<Permission> permissions;

}
