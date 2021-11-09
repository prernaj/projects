package com.example.cab_booking_ua.exceptions;

public class RiderAlreadyExistsException extends RuntimeException {
    public RiderAlreadyExistsException() {

    }

    public RiderAlreadyExistsException(String msg) {
        super(msg);
    }
    
}
