package com.example.application.cache;

import org.jetbrains.annotations.NotNull;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ScheduleCacheManager implements CacheManager {
    private final HashMap<String, Cache> cacheMap = new HashMap<>();

    public ScheduleCacheManager() {}

    @Override
    public Cache getCache(@NotNull String name) {
        return this.cacheMap.get(name);
    }

    @Override
    public Collection<String> getCacheNames() {
        return this.cacheMap.keySet();
    }

    public void setCacheNames(List<String> cacheNames){
        for (String name : cacheNames) {
            this.cacheMap.put(name, this.createCache(name));
        }
    }

    public Cache createCache(String name){
        return new ScheduleCache(name);
    }
}
