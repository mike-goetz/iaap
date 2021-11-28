package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.model.AttributeStatusTransition.Localization;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "attribute_status_transition")
public class AttributeStatusTransition extends AbstractStatusTransition<Localization> {

  @Entity
  @Table(name = "attribute_status_transition_l10n")
  public static class Localization extends AbstractLocalization {

  }
}
