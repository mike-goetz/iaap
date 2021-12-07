package ch.mike.goetz.iaap.server.model;

import com.google.common.base.MoreObjects;
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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(
    name = "app_user",
    indexes = {@Index(columnList = "username", unique = true)})
public class User implements Persistable<Long>, Serializable {

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
  private String username;

  private String password;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "contact_id")
  private Contact contact;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "app_user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  @Override
  public boolean isNew() {
    return id == null;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("username", username)
        .add("contact", contact)
        .add("roles", roles)
        .toString();
  }
}
