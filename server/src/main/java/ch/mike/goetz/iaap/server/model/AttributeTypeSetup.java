package ch.mike.goetz.iaap.server.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.Instant;

@FieldNameConstants
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(
    name = "attribute_type_setup",
    indexes = {@Index(columnList = "attribute_type", unique = true)})
public class AttributeTypeSetup implements Persistable<String>, Serializable {

  @Id
  @Column(name = "attribute_type")
  private String id;

  @Version
  @Column(nullable = false)
  private Long version;

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
  private boolean editable;

  @Column(nullable = false)
  private boolean hideable;

  @Column(nullable = false)
  private boolean deleteable;

  @Column(nullable = false)
  private boolean extendable;

  @Column(nullable = false)
  private boolean sortable;

  public AttributeTypeSetup() {}

  @Override
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
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

  public boolean isEditable() {
    return editable;
  }

  public void setEditable(boolean editable) {
    this.editable = editable;
  }

  public boolean isHideable() {
    return hideable;
  }

  public void setHideable(boolean hideable) {
    this.hideable = hideable;
  }

  public boolean isDeleteable() {
    return deleteable;
  }

  public void setDeleteable(boolean deleteable) {
    this.deleteable = deleteable;
  }

  public boolean isExtendable() {
    return extendable;
  }

  public void setExtendable(boolean extendable) {
    this.extendable = extendable;
  }

  public boolean isSortable() {
    return sortable;
  }

  public void setSortable(boolean sortable) {
    this.sortable = sortable;
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
    AttributeTypeSetup that = (AttributeTypeSetup) o;
    return Objects.equal(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
