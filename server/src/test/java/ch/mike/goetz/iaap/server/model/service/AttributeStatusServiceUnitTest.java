package ch.mike.goetz.iaap.server.model.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.when;

import ch.mike.goetz.iaap.server.model.AbstractStatusTransition;
import ch.mike.goetz.iaap.server.model.AbstractStringPersistable;
import ch.mike.goetz.iaap.server.model.AttributeStatus;
import ch.mike.goetz.iaap.server.model.AttributeStatusTransition;
import ch.mike.goetz.iaap.server.model.repository.AttributeStatusRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AttributeStatusServiceUnitTest {

  @Mock
  AttributeStatusRepository attributeStatusRepository;
  @InjectMocks
  AttributeStatusService attributeStatusService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
    attributeStatusService = new AttributeStatusService(attributeStatusRepository);

    AttributeStatusTransition deactivateTransition = AttributeStatusTransition.builder().active(true).deleted(false).id("ACTIVE->INACTIVE").target("INACTIVE").build();
    AttributeStatusTransition deleteTransition = AttributeStatusTransition.builder().active(false).deleted(true).id("ACTIVE->DELETED").target("DELETED").build();
    AttributeStatus active = AttributeStatus.builder().id("ACTIVE").transitions(Arrays.asList(deactivateTransition, deleteTransition)).build();
    when(attributeStatusRepository.findById("ACTIVE")).thenReturn(Optional.of(active));
  }

  @Test
  void testGetAllowedTransistions() {
    Optional<List<AttributeStatusTransition>> transitions = attributeStatusService.getAllowedTransistions("ACTIVE");
    assertThat(transitions).isPresent();
    assertThat(transitions.get()).extracting(AbstractStringPersistable::getId, AbstractStatusTransition::getTarget).containsExactly(tuple("ACTIVE->INACTIVE", "INACTIVE"));
  }

  @Test
  void testIsTransitionAllowed_activeElement_deactivateTransitionAvailable() {
    assertThat(attributeStatusService.isTransitionAllowed("ACTIVE", "ACTIVE->INACTIVE")).isTrue();
  }

  @Test
  void testIsTransitionAllowed_activeElement_NoDeleteTransitionVisible() {
    assertThat(attributeStatusService.isTransitionAllowed("ACTIVE", "ACTIVE->DELETED")).isFalse();
  }

  @Test
  void testIsTransitionAllowed_activeElement_DoNotAllowADeleteTransition() {
    assertThat(attributeStatusService.isTransitionAllowed("ACTIVE", "INACTIVE->DELETED")).isFalse();
  }
}
