package com.javanoteany.common.shiro.session;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MapCache;
import org.apache.shiro.util.SoftHashMap;
import org.springframework.util.StringUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class RedisCacheManager implements CacheManager{

    private final ConcurrentMap<String, Cache> caches;

    public RedisCacheManager() {
        this.caches = new ConcurrentHashMap<String, Cache>();
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Cache name cannot be null or empty.");
        }
        Cache cache ;
        cache = caches.get(name);
        if(cache == null) {
            cache = new MapCache<Object, Object>(name, new SoftHashMap<Object, Object>());
            Cache existing = caches.putIfAbsent(name, cache);
            if (existing != null) {
                cache = existing;
            }
        }
        return cache;
    }
}
