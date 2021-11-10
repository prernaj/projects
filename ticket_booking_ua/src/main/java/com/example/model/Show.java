package com.example.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Show {
    String id;
    Movie movie;
    Screen screen;
    Date startTime;
    Integer durationInSeconds;
}
