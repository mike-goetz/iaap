package ch.mike.goetz.iaap.server.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gender")
public class Gender extends Attribute<Gender.Localization> {

  @Entity
  @Table(name = "gender_l10n")
  public static class Localization extends AbstractLocalization {}
}
