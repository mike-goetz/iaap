package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.AppLanguage;
import ch.mike.goetz.iaap.server.model.repository.AppLanguageRepository;
import org.springframework.stereotype.Service;

@Service
public class AppLanguageService
    extends AbstractAttributeService<AppLanguage.Localization, AppLanguage> {

  public AppLanguageService(AppLanguageRepository appLanguageRepository) {
    super(appLanguageRepository);
  }
}
