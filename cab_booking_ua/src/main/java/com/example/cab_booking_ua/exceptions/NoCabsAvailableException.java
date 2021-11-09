package com.example.cab_booking_ua.exceptions;

public class NoCabsAvailableException extends RuntimeException {
    public NoCabsAvailableException() {

    }

    public NoCabsAvailableException(String msg) {
        super(msg);
    }
    
}
