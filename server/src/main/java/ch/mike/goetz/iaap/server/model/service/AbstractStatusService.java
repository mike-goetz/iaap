package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.AbstractLocalization;
import ch.mike.goetz.iaap.server.model.AbstractStatus;
import ch.mike.goetz.iaap.server.model.AbstractStatusTransition;
import ch.mike.goetz.iaap.server.model.repository.AttributeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Transactional
public abstract class AbstractStatusService<
        L extends AbstractLocalization,
        LT extends AbstractLocalization,
        T extends AbstractStatusTransition<LT>,
        S extends AbstractStatus<L, LT, T>,
        R extends AttributeRepository<L, S>>
    extends AbstractAttributeService<L, S> {

  protected AbstractStatusService(R repository) {
    super(repository);
  }

  public Optional<List<T>> getAllowedTransitions(String statusId) {
    Optional<S> persistedItem = getRepository().findById(statusId);
    return persistedItem.map(
        s ->
            s.getTransitions().stream()
                .filter(t -> t.isActive() && !t.isDeleted())
                .sorted(comparing(AbstractStatusTransition::getSortOrder))
                .collect(Collectors.toList()));
  }

  public boolean isTransitionAllowed(String statusId, String transitionId) {
    Optional<List<T>> allowedTransitions = getAllowedTransitions(statusId);
    return allowedTransitions
        .map(ts -> ts.stream().anyMatch(t -> StringUtils.equals(t.getId(), transitionId)))
        .orElse(false);
  }
}
