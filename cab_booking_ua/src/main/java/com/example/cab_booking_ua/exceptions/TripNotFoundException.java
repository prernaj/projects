package com.example.cab_booking_ua.exceptions;

public class TripNotFoundException extends RuntimeException {
    public TripNotFoundException() {

    }

    public TripNotFoundException(String msg) {
        super(msg);
    }
    
}
