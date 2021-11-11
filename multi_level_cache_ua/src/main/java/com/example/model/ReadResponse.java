package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@ToString
@Getter
@AllArgsConstructor
public class ReadResponse<Value> {
    Value value;
    Double totalTime;
}
