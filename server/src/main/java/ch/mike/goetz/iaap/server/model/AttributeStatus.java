package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.model.AttributeStatus.Localization;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.HashSet;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "attribute_status")
public class AttributeStatus
    extends AbstractStatus<
        Localization, AttributeStatusTransition.Localization, AttributeStatusTransition> {

  @SuperBuilder
  @Getter
  @Setter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @Entity
  @Table(name = "attribute_status_l10n")
  public static class Localization extends AbstractLocalization {}

  public static AttributeStatus of(String id, AttributeStatusTransition... transitions) {
    AttributeStatus attributeStatus = new AttributeStatus();
    attributeStatus.setId(id);
    attributeStatus.setTransitions(new HashSet<>(Arrays.asList(transitions)));
    return attributeStatus;
  }
}
