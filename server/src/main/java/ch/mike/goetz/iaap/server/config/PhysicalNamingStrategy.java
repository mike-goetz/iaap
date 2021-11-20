package ch.mike.goetz.iaap.server.config;

import static org.hibernate.boot.model.naming.Identifier.toIdentifier;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PhysicalNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {

  @Override
  public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
    Identifier originalIdentifier = super.toPhysicalSequenceName(toIdentifier(name.getText(), name.isQuoted()), jdbcEnvironment);
    if (StringUtils.contains(originalIdentifier.getText(), "$") || StringUtils.containsIgnoreCase(originalIdentifier.getText(), "localization")) {
      var newIdentifier = originalIdentifier.getText().replace("$", "_").replace("localization", "l10n");
      return super.toPhysicalSequenceName(toIdentifier(newIdentifier, name.isQuoted()), jdbcEnvironment);
    }
    return originalIdentifier;
  }

}
