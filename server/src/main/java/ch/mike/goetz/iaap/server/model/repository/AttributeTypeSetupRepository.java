package ch.mike.goetz.iaap.server.model.repository;

import ch.mike.goetz.iaap.server.model.AttributeTypeSetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeTypeSetupRepository
    extends JpaRepository<AttributeTypeSetup, String>,
        JpaSpecificationExecutor<AttributeTypeSetup> {}
