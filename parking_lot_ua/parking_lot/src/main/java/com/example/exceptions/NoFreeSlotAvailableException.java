package com.example.exceptions;

public class NoFreeSlotAvailableException extends RuntimeException {
    public NoFreeSlotAvailableException() {

    }

    public NoFreeSlotAvailableException(String msg) {
        super(msg);
    }
}
