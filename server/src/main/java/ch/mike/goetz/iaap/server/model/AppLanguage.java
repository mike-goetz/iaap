package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.model.AppLanguage.Localization;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "app_language")
public class AppLanguage extends Attribute<Localization> {

  @Entity
  @Table(name = "app_language_l10n")
  public static class Localization extends AbstractLocalization {}

  @Column(nullable = false, length = 2)
  private String language;

  @Column(nullable = false, length = 2)
  private String country;

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
