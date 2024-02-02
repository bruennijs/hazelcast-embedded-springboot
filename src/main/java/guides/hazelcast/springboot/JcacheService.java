package guides.hazelcast.springboot;

import org.springframework.stereotype.Component;

import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheValue;

@Component
public class JcacheService {

    private final String cacheName = "map-hazelcast";

    @CachePut(cacheName = cacheName)
    public void put(String key, @CacheValue String value) {
//        CachingProvider cachingProvider = Caching.getCachingProvider();
//
//        // Create a CacheManager.
//        CacheManager cacheManager = cachingProvider.getCacheManager();
//
//        cacheManager.getCache("map-hazelcast").put(key + "-per-programmatic-jcache-api", value);
    }

    @CacheResult(cacheName = cacheName)
    public String get(@CacheKey String key) {
        return "default value";
    }
}
