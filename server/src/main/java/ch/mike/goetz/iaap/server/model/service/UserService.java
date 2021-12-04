package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.User;
import ch.mike.goetz.iaap.server.model.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, Long, UserRepository> {

  public UserService(UserRepository userRepository) {
    super(userRepository);
  }
}
