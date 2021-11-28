package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.model.AttributeStatus.Localization;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "attribute_status")
public class AttributeStatus extends AbstractStatus<Localization, AttributeStatusTransition.Localization, AttributeStatusTransition> {

  @Entity
  @Table(name = "attribute_status_l10n")
  public static class Localization extends AbstractLocalization {

  }

}
