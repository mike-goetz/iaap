package ch.mike.goetz.iaap.server.model.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import ch.mike.goetz.iaap.server.model.AbstractStatusTransition;
import ch.mike.goetz.iaap.server.model.AbstractStringPersistable;
import ch.mike.goetz.iaap.server.model.AttributeStatus;
import ch.mike.goetz.iaap.server.model.AttributeStatusTransition;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AttributeStatusServiceTest {

  @Autowired
  AttributeStatusService attributeStatusService;

  @Test
  @Order(1)
  void testGetAllowedTransistions() {
    Optional<AttributeStatus> active = attributeStatusService.findById("ACTIVE");
    assertThat(active).isPresent();
    Optional<List<AttributeStatusTransition>> transitions = attributeStatusService.getAllowedTransistions("ACTIVE");
    assertThat(transitions).isPresent();
    assertThat(transitions.get()).extracting(AbstractStringPersistable::getId, AbstractStatusTransition::getTarget).containsOnlyOnce(tuple("ACTIVE->INACTIVE", "INACTIVE"));
  }

  @Test
  @Order(2)
  void testIsTransitionAllowed_activeElement_deactivateTransitionAvailable() {
    assertThat(attributeStatusService.isTransitionAllowed("ACTIVE", "ACTIVE->INACTIVE")).isTrue();
  }

  @Test
  @Order(3)
  void testIsTransitionAllowed_activeElement_NoDeleteTransitionAvailable() {
    assertThat(attributeStatusService.isTransitionAllowed("ACTIVE", "ACTIVE->DELETED")).isFalse();
  }

  @Test
  @Order(3)
  void testIsTransitionAllowed_activeElement_DoNotAllowADeleteTransition() {
    assertThat(attributeStatusService.isTransitionAllowed("ACTIVE", "INACTIVE->DELETED")).isFalse();
  }
}
