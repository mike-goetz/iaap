package ch.mike.goetz.iaap.server.model.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public abstract class AbstractService<
    T, PK, R extends JpaRepository<T, PK> & JpaSpecificationExecutor<T>> {

  private final R repository;

  /**
   * Count {@link T} items.
   *
   * @return number of all items
   */
  public long count() {
    return repository.count();
  }

  /**
   * Count {@link T} items.
   *
   * @param specification the specification
   * @return number of all items
   */
  public long count(Specification<T> specification) {
    return repository.count(specification);
  }

  /**
   * Save {@link T}.
   *
   * @param item to save
   * @return the persisted item
   */
  public T save(T item) {
    return repository.save(item);
  }

  /**
   * Save {@link T}.
   *
   * @param item to save
   * @return the persisted item
   */
  public T saveAndFlush(T item) {
    return repository.saveAndFlush(item);
  }

  /**
   * Save {@link T} items.
   *
   * @param items to save
   */
  public void save(Iterable<T> items) {
    repository.saveAll(items);
  }

  /**
   * Find {@link T} by its id.
   *
   * @param id the status id constant value
   * @return the {@link T} status or null
   */
  public Optional<T> findById(PK id) {
    return repository.findById(id);
  }

  /**
   * Method one by specification.
   *
   * @param specification the specification
   * @return the item
   */
  public Optional<T> findOne(Specification<T> specification) {
    return repository.findOne(specification);
  }

  /**
   * Method all by specification.
   *
   * @return the items
   */
  public Collection<T> findAll() {
    return repository.findAll();
  }

  /**
   * Method all by specification.
   *
   * @param specification the specification
   * @return the items
   */
  public Collection<T> findAll(Specification<T> specification) {
    return repository.findAll(specification);
  }
}
