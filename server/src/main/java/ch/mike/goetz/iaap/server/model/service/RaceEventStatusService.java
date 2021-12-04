package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.RaceEvent;
import ch.mike.goetz.iaap.server.model.repository.RaceEventStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class RaceEventStatusService
    extends AbstractStatusService<
        RaceEvent.Status.Localization,
        RaceEvent.StatusTransition.Localization,
        RaceEvent.StatusTransition,
        RaceEvent.Status,
        RaceEventStatusRepository> {

  public RaceEventStatusService(RaceEventStatusRepository raceEventStatusRepository) {
    super(raceEventStatusRepository);
  }
}
