package com.example.exceptions;

public class SeatPermanentlyUnavailableException extends RuntimeException {
    public SeatPermanentlyUnavailableException() {

    }

    public SeatPermanentlyUnavailableException(String msg) {
        super(msg);
    }
    
}
