package ch.mike.goetz.iaap.server.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.Instant;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractLocalization implements Persistable<Long>, Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "optimized-sequence")
  private Long id;

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

  @Column(nullable = false)
  private String type;

  @Column(nullable = false)
  private String languageCode;

  @Column(nullable = false, length = 2000)
  private String value;

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("type", type)
        .add("languageCode", languageCode)
        .add("value", value)
        .toString();
  }

  @Override
  public boolean isNew() {
    return id == null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractLocalization that = (AbstractLocalization) o;
    return Objects.equal(id, that.id)
        && Objects.equal(type, that.type)
        && Objects.equal(languageCode, that.languageCode);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, type, languageCode);
  }
}
