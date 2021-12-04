package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.AbstractStatusTransition;
import ch.mike.goetz.iaap.server.model.AbstractStringPersistable;
import ch.mike.goetz.iaap.server.model.AttributeStatusTransition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@SpringBootTest
@Disabled("Spring boot test is not required here, too slow @see AttributeStatsServiceUnitTest")
class AttributeStatusServiceTest {

  @Autowired AttributeStatusService attributeStatusService;

  @Test
  void testGetAllowedTransistions() {
    Optional<List<AttributeStatusTransition>> transitions =
        attributeStatusService.getAllowedTransitions("ACTIVE");
    assertThat(transitions).isPresent();
    assertThat(transitions.get())
        .extracting(AbstractStringPersistable::getId, AbstractStatusTransition::getTarget)
        .containsExactly(tuple("ACTIVE->INACTIVE", "INACTIVE"));
  }

  @Test
  void testIsTransitionAllowed_activeElement_deactivateTransitionAvailable() {
    assertThat(attributeStatusService.isTransitionAllowed("ACTIVE", "ACTIVE->INACTIVE")).isTrue();
  }

  @Test
  void testIsTransitionAllowed_activeElement_NoDeleteTransitionAvailable() {
    assertThat(attributeStatusService.isTransitionAllowed("ACTIVE", "ACTIVE->DELETED")).isFalse();
  }

  @Test
  void testIsTransitionAllowed_activeElement_DoNotAllowADeleteTransition() {
    assertThat(attributeStatusService.isTransitionAllowed("ACTIVE", "INACTIVE->DELETED")).isFalse();
  }
}
