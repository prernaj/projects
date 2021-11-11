package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StatsResponse {
    private final Double avgReadTime;
    private final Double avgWriteTime;
    private final List<Double> usages;
}
