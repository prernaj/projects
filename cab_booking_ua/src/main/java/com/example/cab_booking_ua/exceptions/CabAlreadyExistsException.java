package com.example.cab_booking_ua.exceptions;

public class CabAlreadyExistsException extends RuntimeException {
    public CabAlreadyExistsException() {

    }

    public CabAlreadyExistsException(String msg) {
        super(msg);
    }
}
