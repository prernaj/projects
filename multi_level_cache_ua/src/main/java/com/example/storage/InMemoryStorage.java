package com.example.storage;

import java.util.HashMap;
import java.util.Map;

import com.example.exception.StorageFullException;

public class InMemoryStorage<Key, Value> implements Storage<Key, Value> {
    private final Map<Key, Value> storage;
    private final Integer capacity;

    public InMemoryStorage(Integer capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<Key, Value>();
    }
    
    public void add(Key key, Value value) throws StorageFullException {
        if (isStorageFull()) {
            throw new StorageFullException();
        }
        storage.put(key, value);
    }

    public Value get(Key key) {
        return storage.get(key);
    }

    public void remove(Key key) {
        storage.remove(key);
    }

    public double getCurrentUsage() {
        return ((double) storage.size()) / ((double) capacity);
    }

    private boolean isStorageFull() {
        return storage.size() == capacity;
    }
    
}
