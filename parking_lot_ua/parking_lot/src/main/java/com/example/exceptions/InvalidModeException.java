package com.example.exceptions;

public class InvalidModeException extends RuntimeException {
    public InvalidModeException() {

    }

    public InvalidModeException(String msg) {
        super(msg);
    }
}
