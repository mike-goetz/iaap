package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.Contact;
import ch.mike.goetz.iaap.server.model.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService extends AbstractService<Contact, Long, ContactRepository> {

  public ContactService(ContactRepository contactRepository) {
    super(contactRepository);
  }

}
