package ch.mike.goetz.iaap.server;

import ch.mike.goetz.iaap.server.model.AbstractLocalization;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public final class LocalizationUtil {

  private LocalizationUtil() {
  }

  public static <T extends AbstractLocalization, V> Optional<V> map(Set<T> localizations, String localizationType, String userLanguage, Function<T, V> mapper) {
    if (CollectionUtils.isNotEmpty(localizations)) {
      Optional<T> localization;

      localization = localizations.stream()
          .filter(l -> StringUtils.equals(l.getType(), localizationType) && StringUtils.equals(l.getLanguageCode(), userLanguage))
          .findFirst();
      if (localization.isPresent()) {
        return localization.map(mapper);
      }

      localization = localizations.stream()
          .filter(l -> StringUtils.equals(l.getType(), localizationType) && StringUtils.equals(l.getLanguageCode(), "en")).findFirst();
      if (localization.isPresent()) {
        return localization.map(mapper);
      }

      localization = localizations.stream().filter(l -> StringUtils.equals(l.getType(), localizationType)).findFirst();
      if (localization.isPresent()) {
        return localization.map(mapper);
      }
    }
    return Optional.empty();
  }
}
