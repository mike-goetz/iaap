package ch.mike.goetz.iaap.server.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@FieldNameConstants
@SuperBuilder
@NoArgsConstructor
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(
    name = "attribute_type_setup",
    indexes = {@Index(columnList = "attribute_type", unique = true)}
)
public class AttributeTypeSetup implements Persistable<String>, Serializable {

  @Id
  @Column(name = "attribute_type")
  private String id;

  @Version
  @Column(nullable = false)
  private long version;

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

  @Column(nullable = false)
  private boolean editable;

  @Column(nullable = false)
  private boolean hideable;

  @Column(nullable = false)
  private boolean deleteable;

  @Column(nullable = false)
  private boolean extendable;

  @Column(nullable = false)
  private boolean sortable;

  @Override
  public boolean isNew() {
    return createdDate == null;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
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
    AttributeTypeSetup that = (AttributeTypeSetup) o;
    return Objects.equal(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
