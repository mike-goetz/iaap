package ch.mike.goetz.iaap.server.config;

import ch.mike.goetz.iaap.server.model.User;
import ch.mike.goetz.iaap.server.model.repository.UserRepository;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareImpl implements AuditorAware<User> {

  private final UserRepository userRepository;
  private User systemUser;

  public AuditorAwareImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Optional<User> getCurrentAuditor() {
    if (systemUser == null) {
      systemUser = userRepository.findOne((root, query, cb) -> cb.equal(root.get(User.Fields.username), "SYSTEM")).orElse(null);
    }
    return Optional.of(systemUser);
  }

}
