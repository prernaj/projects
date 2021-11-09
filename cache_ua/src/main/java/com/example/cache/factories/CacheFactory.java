package com.example.cache.factories;

import com.example.cache.Cache;
import com.example.cache.policies.LRUEvictionPolicy;
import com.example.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {
    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(), new HashMapBasedStorage<Key, Value>(capacity));
    }
}
