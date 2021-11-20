package ch.mike.goetz.iaap.server.model.repository;

import ch.mike.goetz.iaap.server.model.AttributeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeTypeRepository extends JpaRepository<AttributeType, String>, JpaSpecificationExecutor<AttributeType> {

}
