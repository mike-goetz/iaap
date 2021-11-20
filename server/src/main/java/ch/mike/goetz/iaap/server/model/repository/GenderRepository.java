package ch.mike.goetz.iaap.server.model.repository;

import ch.mike.goetz.iaap.server.model.Gender;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends ch.mike.goetz.iaap.server.model.repository.AttributeRepository<Gender.Localization, Gender> {

}
