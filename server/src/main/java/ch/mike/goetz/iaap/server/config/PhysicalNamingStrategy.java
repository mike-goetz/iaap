package ch.mike.goetz.iaap.server.config;

import static org.hibernate.boot.model.naming.Identifier.toIdentifier;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PhysicalNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {

  @Override
  public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
    Identifier originalIdentifier = super.toPhysicalTableName(name, jdbcEnvironment);
    if (nameModificationNeeded(originalIdentifier)) {
      return super.toPhysicalTableName(getModifiedIdentifier(name, originalIdentifier), jdbcEnvironment);
    }
    return originalIdentifier;
  }

  @Override
  public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
    Identifier originalIdentifier = super.toPhysicalSequenceName(name, jdbcEnvironment);
    if (nameModificationNeeded(originalIdentifier)) {
      return super.toPhysicalSequenceName(getModifiedIdentifier(name, originalIdentifier), jdbcEnvironment);
    }
    return originalIdentifier;
  }

  private static boolean nameModificationNeeded(Identifier originalIdentifier) {
    return StringUtils.contains(originalIdentifier.getText(), "$") || StringUtils.containsIgnoreCase(originalIdentifier.getText(), "localization");
  }

  private static Identifier getModifiedIdentifier(Identifier name, Identifier originalIdentifier) {
    return toIdentifier(updateIdentifier(originalIdentifier), name.isQuoted());
  }

  private static String updateIdentifier(Identifier originalIdentifier) {
    return originalIdentifier.getText().replace("$", "_").replace("localization", "l10n");
  }

}
