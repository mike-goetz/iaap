package ch.mike.goetz.iaap.server.helper;

import ch.mike.goetz.iaap.server.model.AbstractLocalization;
import ch.mike.goetz.iaap.server.model.AbstractStatus;
import ch.mike.goetz.iaap.server.model.AbstractStatusTransition;
import ch.mike.goetz.iaap.server.model.AttributeType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Set;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class StatusImport<
        L extends AbstractLocalization,
        LT extends AbstractLocalization,
        T extends AbstractStatusTransition<LT>,
        S extends AbstractStatus<L, LT, T>>
    implements Serializable {

  private AttributeType attributeType;
  private Set<S> attributes;
}
