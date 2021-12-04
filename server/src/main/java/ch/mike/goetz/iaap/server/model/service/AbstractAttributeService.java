package ch.mike.goetz.iaap.server.model.service;

import ch.mike.goetz.iaap.server.model.AbstractLocalization;
import ch.mike.goetz.iaap.server.model.Attribute;
import ch.mike.goetz.iaap.server.model.repository.AttributeRepository;
import org.apache.commons.collections4.CollectionUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractAttributeService<
        L extends AbstractLocalization, T extends Attribute<L>>
    extends AbstractService<T, String, AttributeRepository<L, T>> {

  protected AbstractAttributeService(AttributeRepository<L, T> repository) {
    super(repository);
  }

  /**
   * Method to get all {@link T} values within a map of identifier and identity.
   *
   * @return map of all status values.
   */
  public Map<String, T> getIdentifierMap() {
    return getRepository().findAll().stream()
        .collect(Collectors.toMap(Attribute::getId, Function.identity()));
  }

  /**
   * Method to get attributes mapped to their default name in English. Since those localizations are
   * not unique, a list of all attributes sharing the same default name is returned.
   *
   * @return map of all attributes mapped to their default name.
   */
  @Transactional
  public Map<String, List<T>> getDefaultNameMap() {
    List<T> all = getRepository().findAll();
    if (CollectionUtils.isNotEmpty(all)) {
      Map<String, List<T>> itemsByName = new HashMap<>();
      for (T attribute : all) {
        String name = attribute.getName("en");
        List<T> attributeList;
        if (!itemsByName.containsKey(name)) {
          attributeList = new ArrayList<>();
          itemsByName.put(name, attributeList);
        } else {
          attributeList = itemsByName.get(name);
        }
        attributeList.add(attribute);
      }
      return itemsByName;
    }
    return Collections.emptyMap();
  }
}
