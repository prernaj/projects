package com.example.provider;

import java.util.List;

import com.example.model.ReadResponse;
import com.example.model.WriteResponse;

import lombok.NonNull;

public interface ILevelCache<Key, Value> {
    
    @NonNull
    WriteResponse set(Key key, Value value);

    @NonNull
    ReadResponse<Value> get(Key key);

    @NonNull
    List<Double> getUsages();
}
