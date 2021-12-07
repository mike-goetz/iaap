package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.model.Permission.Localization;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "app_permission")
public class Permission extends Attribute<Localization> {

  @SuperBuilder
  @Getter
  @Setter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @Entity
  @Table(name = "app_permission_l10n")
  public static class Localization extends AbstractLocalization {}
}
