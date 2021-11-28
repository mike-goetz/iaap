package ch.mike.goetz.iaap.server;

import ch.mike.goetz.iaap.server.model.AppLanguage;
import ch.mike.goetz.iaap.server.model.AttributeStatus;
import ch.mike.goetz.iaap.server.model.Gender;
import ch.mike.goetz.iaap.server.model.Permission;
import ch.mike.goetz.iaap.server.model.Role;
import ch.mike.goetz.iaap.server.model.service.AttributeService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCache {

  private final LoadingCache<String, Optional<AttributeStatus>> attributeStatusCache;
  private final LoadingCache<String, Optional<AppLanguage>> appLanguageCache;
  private final LoadingCache<String, Optional<Gender>> genderCache;
  private final LoadingCache<String, Optional<Permission>> permissionCache;
  private final LoadingCache<String, Optional<Role>> roleCache;

  public ApplicationCache(AttributeService attributeService) {
    attributeStatusCache = cacheDaily(id -> attributeService.getAttributeStatusService().findById(id));
    appLanguageCache = cacheDaily(id -> attributeService.getAppLanguageService().findById(id));
    genderCache = cacheDaily(id -> attributeService.getGenderService().findById(id));
    permissionCache = cacheDaily(id -> attributeService.getPermissionService().findById(id));
    roleCache = cacheDaily(id -> attributeService.getRoleService().findById(id));
  }

  //@formatter:off
  public Optional<AttributeStatus> getAttributeStatus(String id) { return attributeStatusCache.getUnchecked(id); }
  public Optional<AppLanguage> getAppLanguage(String id) { return appLanguageCache.getUnchecked(id); }
  public Optional<Gender> getGender(String id) { return genderCache.getUnchecked(id); }
  public Optional<Permission> getPermission(String id) { return permissionCache.getUnchecked(id); }
  public Optional<Role> getRole(String id) { return roleCache.getUnchecked(id); }
  //@formatter:on

  private static <K, V> LoadingCache<K, V> cacheDaily(Resolver<K, V> resolver) {
    return cache(() -> CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.DAYS), resolver);
  }

  private static <K, V> LoadingCache<K, V> cache(Supplier<CacheBuilder<Object, Object>> cacheBuilder, Resolver<K, V> resolver) {
    return cacheBuilder.get().build(new CacheLoader<K, V>() {
      @Override
      public V load(K key) {
        return resolver.find(key);
      }
    });
  }

  @FunctionalInterface
  public interface Resolver<K, V> {

    V find(K key);
  }
}
