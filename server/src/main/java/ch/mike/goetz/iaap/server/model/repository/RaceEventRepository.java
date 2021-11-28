package ch.mike.goetz.iaap.server.model.repository;

import ch.mike.goetz.iaap.server.model.RaceEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceEventRepository extends JpaRepository<RaceEvent, Long>, JpaSpecificationExecutor<RaceEvent> {

}
