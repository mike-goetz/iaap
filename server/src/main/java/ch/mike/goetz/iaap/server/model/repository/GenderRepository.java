package ch.mike.goetz.iaap.server.model.repository;

import ch.mike.goetz.iaap.server.model.Gender;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends AttributeRepository<Gender.Localization, Gender> {}
