package ch.mike.goetz.iaap.server.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@FieldNameConstants
@MappedSuperclass
public abstract class AbstractStatus<L extends AbstractLocalization, LT extends AbstractLocalization, T extends AbstractStatusTransition<LT>> extends Attribute<L> {

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "status")
  private final Set<T> transitions = new HashSet<>();

  public Set<T> getTransitions() {
    return transitions;
  }

  public final void addTransition(T transition) {
    if (transition != null) {
      transitions.add(transition);
    }
  }
}
