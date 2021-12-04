package ch.mike.goetz.iaap.server.helper;

import ch.mike.goetz.iaap.server.model.AbstractLocalization;
import ch.mike.goetz.iaap.server.model.AbstractStatus;
import ch.mike.goetz.iaap.server.model.AbstractStatusTransition;
import ch.mike.goetz.iaap.server.model.AttributeType;

import java.io.Serializable;
import java.util.Set;

public class StatusImport<
        L extends AbstractLocalization,
        LT extends AbstractLocalization,
        T extends AbstractStatusTransition<LT>,
        S extends AbstractStatus<L, LT, T>>
    implements Serializable {

  private AttributeType attributeType;
  private Set<S> attributes;

  public AttributeType getAttributeType() {
    return attributeType;
  }

  public void setAttributeType(AttributeType attributeType) {
    this.attributeType = attributeType;
  }

  public Set<S> getAttributes() {
    return attributes;
  }

  public void setAttributes(Set<S> attributes) {
    this.attributes = attributes;
  }
}
