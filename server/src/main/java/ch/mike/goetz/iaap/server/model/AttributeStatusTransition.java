package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.model.AttributeStatusTransition.Localization;
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
@Table(name = "attribute_status_transition")
public class AttributeStatusTransition extends AbstractStatusTransition<Localization> {

  @SuperBuilder
  @Getter
  @Setter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @Entity
  @Table(name = "attribute_status_transition_l10n")
  public static class Localization extends AbstractLocalization {}
}
