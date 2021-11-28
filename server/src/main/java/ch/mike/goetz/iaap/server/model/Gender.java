package ch.mike.goetz.iaap.server.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gender")
public class Gender extends Attribute<Gender.Localization> {

  @Entity
  @Table(name = "gender_l10n")
  public static class Localization extends AbstractLocalization {

  }

}
