package com.example.application.cache;

import org.jetbrains.annotations.NotNull;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class ScheduleCache implements Cache {
    private final String name;
    private final HashMap<Object, Object> store;

    public ScheduleCache(String name) {
        this(name, new HashMap<>());
    }

    public ScheduleCache(String name, HashMap<Object, Object> store) {
        this.name = name;
        this.store = store;
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public @NotNull Object getNativeCache() {
        return this.store;
    }

    @Override
    public ValueWrapper get(@NotNull Object key) {
        return this.toValueWrapper(this.store.get(key));
    }

    @Override
    public <T> T get(@NotNull Object key, Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T get(@NotNull Object key, Callable<T> callable) {
        return (T) this.store.computeIfAbsent(key, (k) -> {
            try {
                return callable.call();
            } catch (Throwable e) {
                throw new ValueRetrievalException(key, callable, e);
            }
        });
    }

    @Override
    public void put(@NotNull Object key, Object value) {
        this.store.put(key, value);
    }

    @Override
    public ValueWrapper putIfAbsent(@NotNull Object key, Object value) {
        Object res_object = this.store.putIfAbsent(key, value);
        return this.toValueWrapper(res_object);
    }

    @Override
    public void evict(@NotNull Object key) {
        this.store.remove(key);
    }

    @Override
    public boolean evictIfPresent(@NotNull Object key) {
        return this.store.remove(key) != null;
    }

    @Override
    public void clear() {
        this.store.clear();
    }

    @Override
    public boolean invalidate() {
        boolean notEmpty = !this.store.isEmpty();
        this.store.clear();
        return notEmpty;
    }

    private ValueWrapper toValueWrapper(@Nullable Object storeValue) {
        return storeValue != null ? new SimpleValueWrapper(storeValue) : null;
    }
}
