package com.example.cab_booking_ua.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Location {
    Double x;
    Double y;

    public Double distance(Location location2) {
        return Math.sqrt( Math.pow((this.x - location2.x), 2.0) + Math.pow((this.y - location2.y), 2.0));
    }
}
