package ch.mike.goetz.iaap.server.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@FieldNameConstants
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public abstract class AbstractPersistable implements Persistable<Long> {

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

  @LastModifiedDate
  private Instant lastModifiedDate;

  @LastModifiedBy
  @ManyToOne(fetch = FetchType.LAZY)
  private User lastModifiedBy;

  @Override
  public boolean isNew() {
    return id == null;
  }
}
