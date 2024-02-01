package guides.hazelcast.springboot;

import com.hazelcast.core.HazelcastInstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentMap;

import javax.cache.annotation.CacheResult;

@RestController()
@RequestMapping(path = "jcache")
public class JcacheController {

    @PostMapping("/put")
    public CommandResponse put(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        putToCache(key, value);
        return new CommandResponse("Entry put to cache");
    }

    @GetMapping("/get")
    public CommandResponse get(@RequestParam(value = "key") String key) {
        return new CommandResponse(getFromCache(key));
    }

    @CachePut(cacheNames = "map-jcache", key = "key")
    public String putToCache(String key, String value) {
        return value;
    }

    @CacheResult(cacheName = "map-jcache")
    private String getFromCache(String key) {
        throw new RuntimeException("No value found for key " + key);
    }
}
