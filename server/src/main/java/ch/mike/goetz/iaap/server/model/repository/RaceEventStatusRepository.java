package ch.mike.goetz.iaap.server.model.repository;

import ch.mike.goetz.iaap.server.model.RaceEvent;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceEventStatusRepository extends AttributeRepository<RaceEvent.Status.Localization, RaceEvent.Status> {

}
