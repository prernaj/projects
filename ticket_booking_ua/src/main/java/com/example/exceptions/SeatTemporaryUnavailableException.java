package com.example.exceptions;

public class SeatTemporaryUnavailableException extends RuntimeException {
    public SeatTemporaryUnavailableException() {

    }

    public SeatTemporaryUnavailableException(String msg) {
        super(msg);
    }
    
}
