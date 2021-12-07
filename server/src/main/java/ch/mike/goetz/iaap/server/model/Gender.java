package ch.mike.goetz.iaap.server.model;

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
@Table(name = "gender")
public class Gender extends Attribute<Gender.Localization> {

  @SuperBuilder
  @Getter
  @Setter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @Entity
  @Table(name = "gender_l10n")
  public static class Localization extends AbstractLocalization {}
}
