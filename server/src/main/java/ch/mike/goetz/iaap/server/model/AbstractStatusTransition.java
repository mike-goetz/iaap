package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.LocalizationUtil;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractStatusTransition<T extends AbstractLocalization>
    extends AbstractStringPersistable {

  public static final String SYSTEM = "SYSTEM";
  public static final String USER = "USER";

  @Column(nullable = false)
  private String origin;

  @Column(nullable = false)
  private String target;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "transition")
  private final Set<T> localizations = new HashSet<>();

  @Column(nullable = false)
  private boolean deleted = false;

  @Column(nullable = false)
  private boolean active = true;

  private Integer sortOrder;

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public Set<T> getLocalizations() {
    return localizations;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
  }

  /**
   * Add provided localization.
   *
   * @param localization to add
   */
  public final void addLocalization(T localization) {
    if (localization != null) {
      localizations.add(localization);
    }
  }

  /**
   * Get localization by type in user language (iso3code).
   *
   * @param localizationType the tyoe (NAME, SYNONYM etc)
   * @param userLanguage the language code (e.g. en or de)
   * @return the requested String
   */
  public String getLocalization(String localizationType, String userLanguage) {
    return LocalizationUtil.map(
            this.localizations, localizationType, userLanguage, AbstractLocalization::getValue)
        .orElse(getId());
  }

  /**
   * Get localization type NAME.
   *
   * @param userLanguage the prefered language, fallback to en if nothing available
   * @return the requested String
   */
  public String getName(String userLanguage) {
    return getLocalization("NAME", userLanguage);
  }

  /**
   * Method to see if I am a system attribute.
   *
   * @return true if attribute is a system attribute
   */
  public boolean isSystem() {
    return StringUtils.equals(origin, SYSTEM);
  }

  /**
   * Method to return if this item has the provided identifier.
   *
   * @param myIdentifier the identifier
   * @return true or false
   */
  public boolean hasIdentifier(String myIdentifier) {
    return StringUtils.equals(getId(), myIdentifier);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("id", getId()).add("origin", origin).toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractStatusTransition<?> statusTransition = (AbstractStatusTransition<?>) o;
    return Objects.equal(getId(), statusTransition.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }
}
