package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.model.Permission.Localization;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "app_permission")
public class Permission extends Attribute<Localization> {

  @Entity
  @Table(name = "app_permission_l10n")
  public static class Localization extends AbstractLocalization {}
}
