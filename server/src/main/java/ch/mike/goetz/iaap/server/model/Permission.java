package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.model.Permission.Localization;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@FieldNameConstants
@Entity
@Table(name = "app_permission")
public class Permission extends Attribute<Localization> {

  @Entity
  @Table(name = "app_permission_l10n")
  public static class Localization extends AbstractLocalization {

  }

}
