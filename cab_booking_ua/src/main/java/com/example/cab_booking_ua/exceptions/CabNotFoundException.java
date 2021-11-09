package com.example.cab_booking_ua.exceptions;

public class CabNotFoundException extends RuntimeException {
    public CabNotFoundException() {

    }

    public CabNotFoundException(String msg) {
        super(msg);
    }
    
}
