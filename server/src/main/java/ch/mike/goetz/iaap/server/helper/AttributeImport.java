package ch.mike.goetz.iaap.server.helper;

import ch.mike.goetz.iaap.server.model.AbstractLocalization;
import ch.mike.goetz.iaap.server.model.Attribute;
import ch.mike.goetz.iaap.server.model.AttributeType;
import java.io.Serializable;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttributeImport<L extends AbstractLocalization, T extends Attribute<L>> implements Serializable {

  private AttributeType attributeType;
  private Set<T> attributes;

}
