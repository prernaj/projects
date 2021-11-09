package com.example.cab_booking_ua.exceptions;

public class RiderNotFoundException extends RuntimeException {
    public RiderNotFoundException() {

    }
    public RiderNotFoundException(String msg) {
        super(msg);
    }
}
