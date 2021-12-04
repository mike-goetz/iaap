package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.Gender;
import ch.mike.goetz.iaap.server.model.repository.GenderRepository;
import org.springframework.stereotype.Service;

@Service
public class GenderService extends AbstractAttributeService<Gender.Localization, Gender> {

  public GenderService(GenderRepository genderRepository) {
    super(genderRepository);
  }
}
