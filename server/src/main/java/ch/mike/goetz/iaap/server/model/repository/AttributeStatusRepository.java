package ch.mike.goetz.iaap.server.model.repository;

import ch.mike.goetz.iaap.server.model.AttributeStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeStatusRepository
    extends AttributeRepository<AttributeStatus.Localization, AttributeStatus> {}
