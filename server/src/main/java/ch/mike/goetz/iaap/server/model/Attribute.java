package ch.mike.goetz.iaap.server.model;

import ch.mike.goetz.iaap.server.LocalizationUtil;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@FieldNameConstants
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class Attribute<T extends AbstractLocalization> implements Persistable<String>, Serializable {

  public static final String SYSTEM = "SYSTEM";
  public static final String USER = "USER";

  @Id
  private String id;

  @Version
  @Column(nullable = false)
  private long version = 0;

  @CreatedDate
  @Column(nullable = false, updatable = false)
  private Instant createdDate;

  @CreatedBy
  @ManyToOne(fetch = FetchType.LAZY)
  private User createdBy;

  @LastModifiedDate
  private Instant lastModifiedDate;

  @LastModifiedBy
  @ManyToOne(fetch = FetchType.LAZY)
  private User lastModifiedBy;

  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  @JoinColumn(name = "attribute_type")
  private AttributeType attributeType;

  @Column(nullable = false)
  private String origin;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "attribute")
  private final Set<T> localizations = new HashSet<>();

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "status")
  private AttributeStatus status;

  private Integer sortOrder;

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
   * @param userLanguage     the language code (e.g. en or de)
   * @return the requested String
   */
  public String getLocalization(String localizationType, String userLanguage) {
    return LocalizationUtil.map(this.localizations, localizationType, userLanguage, AbstractLocalization::getValue).orElse(getId());
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
  public boolean isNew() {
    return createdDate == null;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("origin", origin)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attribute<?> attribute = (Attribute<?>) o;
    return Objects.equal(id, attribute.id) && Objects.equal(attributeType, attribute.attributeType);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, attributeType);
  }
}
