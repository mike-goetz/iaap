package ch.mike.goetz.iaap.server.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;
import org.apache.commons.collections4.CollectionUtils;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class AbstractStatus<
        L extends AbstractLocalization,
        LT extends AbstractLocalization,
        T extends AbstractStatusTransition<LT>>
    extends Attribute<L> {

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "status")
  @Singular
  private Set<T> transitions;

  protected void setTransitions(Set<T> transitions) {
    if (this.transitions == null) {
      this.transitions = new HashSet<>();
    } else {
      this.transitions.clear();
    }
    addTransitions(transitions);
  }

  public void addTransitions(Collection<T> transitions) {
    if (CollectionUtils.isNotEmpty(transitions)) {
      transitions.forEach(this::addTransition);
    }
  }

  public final void addTransition(T transition) {
    CollectionUtils.addIgnoreNull(transitions, transition);
  }
}
