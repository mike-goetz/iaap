package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.model.AppLanguage.Localization;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@FieldNameConstants
@Entity
@Table(name = "app_language")
public class AppLanguage extends Attribute<Localization> {

  @Entity
  @Table(name = "app_language_l10n")
  public static class Localization extends AbstractLocalization {

  }

  @Column(nullable = false, length = 2)
  private String language;

  @Column(nullable = false, length = 2)
  private String country;

}
