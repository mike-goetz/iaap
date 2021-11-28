package ch.mike.goetz.iaap.server.model;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(name = "race_event")
public class RaceEvent implements Persistable<Long>, Serializable {

  @Entity
  @Table(name = "race_event_status")
  public class Status extends AbstractStatus<Status.Localization, StatusTransition.Localization, StatusTransition> {

    @Entity
    @Table(name = "race_event_status_l10n")
    public static class Localization extends AbstractLocalization {

    }

  }

  @Entity
  @Table(name = "race_event_status_transition")
  public class StatusTransition extends AbstractStatusTransition<StatusTransition.Localization> {

    @Entity
    @Table(name = "race_event_status_transition_l10n")
    public static class Localization extends AbstractLocalization {

    }
  }

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

  private Instant start;

  private Instant end;

  private String name;

  private String description;

  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  private Status status;

  @Override
  public boolean isNew() {
    return id == null;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("start", start)
        .add("name", name)
        .add("status", status)
        .toString();
  }
}
