package ch.mike.goetz.iaap.server.helper;

import ch.mike.goetz.iaap.server.model.AbstractLocalization;
import ch.mike.goetz.iaap.server.model.Attribute;
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
public class AttributeImport<L extends AbstractLocalization, T extends Attribute<L>>
    implements Serializable {

  private AttributeType attributeType;
  private Set<T> attributes;
}
