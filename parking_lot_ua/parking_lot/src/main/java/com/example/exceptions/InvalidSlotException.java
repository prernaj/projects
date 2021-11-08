package com.example.exceptions;

public class InvalidSlotException extends RuntimeException {
    public InvalidSlotException() {

    }

    public InvalidSlotException(String msg) {
        super(msg);
    }
}
