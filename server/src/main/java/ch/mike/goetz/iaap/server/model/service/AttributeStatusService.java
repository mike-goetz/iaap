package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.AttributeStatus;
import ch.mike.goetz.iaap.server.model.AttributeStatusTransition;
import ch.mike.goetz.iaap.server.model.repository.AttributeStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class AttributeStatusService extends AbstractStatusService<
    AttributeStatus.Localization,
    AttributeStatusTransition.Localization,
    AttributeStatusTransition,
    AttributeStatus,
    AttributeStatusRepository> {

  public AttributeStatusService(AttributeStatusRepository attributeStatusRepository) {
    super(attributeStatusRepository);
  }

}
