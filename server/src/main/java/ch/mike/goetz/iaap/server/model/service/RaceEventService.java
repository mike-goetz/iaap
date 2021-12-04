package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.RaceEvent;
import ch.mike.goetz.iaap.server.model.repository.RaceEventRepository;
import org.springframework.stereotype.Service;

@Service
public class RaceEventService extends AbstractService<RaceEvent, Long, RaceEventRepository> {

  public RaceEventService(RaceEventRepository raceEventRepository) {
    super(raceEventRepository);
  }
}
