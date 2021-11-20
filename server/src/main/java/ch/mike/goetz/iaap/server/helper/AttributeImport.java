package ch.mike.goetz.iaap.server.helper;

import ch.mike.goetz.iaap.server.model.AbstractLocalization;
import ch.mike.goetz.iaap.server.model.Attribute;
import ch.mike.goetz.iaap.server.model.AttributeType;
import java.io.Serializable;
import java.util.Set;

public class AttributeImport<L extends AbstractLocalization, T extends Attribute<L>> implements Serializable {

  private AttributeType attributeType;
  private Set<T> attributes;

  public AttributeType getAttributeType() {
    return attributeType;
  }

  public void setAttributeType(AttributeType attributeType) {
    this.attributeType = attributeType;
  }

  public Set<T> getAttributes() {
    return attributes;
  }

  public void setAttributes(Set<T> attributes) {
    this.attributes = attributes;
  }

}
