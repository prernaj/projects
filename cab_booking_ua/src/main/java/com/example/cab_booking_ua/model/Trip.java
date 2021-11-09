package com.example.cab_booking_ua.model;

import lombok.ToString;

enum TripStatus {
    IN_PROGRESS,
    FINISHED
}

@ToString
public class Trip {
    Rider rider;
    Cab cab;
    TripStatus tripStatus;
    Double price;
    Location fromPoint;
    Location toPoint;

    public Trip(final Rider rider, final Cab cab, final Double price, final Location fromPoint, final Location toPoint) {
        this.rider = rider;
        this.cab = cab;
        this.price = price;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.tripStatus = TripStatus.IN_PROGRESS;
    }

    public void endTrip() {
        this.tripStatus = TripStatus.FINISHED;
    }
}
