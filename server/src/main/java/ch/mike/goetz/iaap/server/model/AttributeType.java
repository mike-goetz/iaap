package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.LocalizationUtil;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(name = "attribute_type")
public class AttributeType implements Persistable<String>, Serializable {

  @Entity
  @Table(name = "attribute_type_l10n")
  public static class Localization extends AbstractLocalization {}

  @Id private String id;

  @Version
  @Column(nullable = false)
  private long version = 0;

  @CreatedDate
  @Column(nullable = false, updatable = false)
  private Instant createdDate;

  @CreatedBy
  @ManyToOne(fetch = FetchType.LAZY)
  private User createdBy;

  @LastModifiedDate private Instant lastModifiedDate;

  @LastModifiedBy
  @ManyToOne(fetch = FetchType.LAZY)
  private User lastModifiedBy;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "attribute_type")
  private final Set<Localization> localizations = new HashSet<>();

  @Column(nullable = false)
  private boolean deleted = false;

  @Column(nullable = false)
  private boolean active = true;

  @Override
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

  public Instant getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Instant createdDate) {
    this.createdDate = createdDate;
  }

  public User getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }

  public Instant getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(Instant lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public User getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(User lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  public Set<Localization> getLocalizations() {
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

  /**
   * Add provided localization.
   *
   * @param localization to add
   */
  public void addLocalization(Localization localization) {
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

  @Override
  public boolean isNew() {
    return createdDate == null;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("id", id).toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttributeType that = (AttributeType) o;
    return Objects.equal(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
