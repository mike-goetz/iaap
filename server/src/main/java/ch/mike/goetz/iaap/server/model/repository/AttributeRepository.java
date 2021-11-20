package ch.mike.goetz.iaap.server.model.repository;

import ch.mike.goetz.iaap.server.model.AbstractLocalization;
import ch.mike.goetz.iaap.server.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository<L extends AbstractLocalization, T extends Attribute<L>> extends JpaRepository<T, String>, JpaSpecificationExecutor<T> {

}
