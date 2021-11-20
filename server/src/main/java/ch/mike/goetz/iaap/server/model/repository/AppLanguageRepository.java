package ch.mike.goetz.iaap.server.model.repository;

import ch.mike.goetz.iaap.server.model.AppLanguage;
import org.springframework.stereotype.Repository;

@Repository
public interface AppLanguageRepository extends AttributeRepository<AppLanguage.Localization, AppLanguage> {

}
