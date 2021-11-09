package com.example.cache;

import com.example.cache.exceptions.NotFoundException;
import com.example.cache.exceptions.StorageFullException;
import com.example.cache.policies.EvictionPolicy;
import com.example.cache.storage.Storage;

public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy; 
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException exception) {
            System.out.println("Got storage full. Will try to evict");
            Key keyToRemove = this.evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected state. storage full and no key to evict.");
            }
            this.storage.remove(keyToRemove);
            put(key, value);
        }
    }

    public Value get(Key key) {
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch(NotFoundException notFoundException) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }
    

}
