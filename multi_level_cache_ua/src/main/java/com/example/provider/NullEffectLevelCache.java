package com.example.provider;

import java.util.Collections;
import java.util.List;

import com.example.model.ReadResponse;
import com.example.model.WriteResponse;

public class NullEffectLevelCache<Key, Value> implements ILevelCache<Key, Value> {
    @Override
    public WriteResponse set(Key key, Value value) {
        return new WriteResponse(0.0);
    }

    @Override
    public ReadResponse<Value> get(Key key) {
        return new ReadResponse<>(null, 0.0);
    }

    @Override
    public List<Double> getUsages() {
        return Collections.emptyList();
    }
    
}
