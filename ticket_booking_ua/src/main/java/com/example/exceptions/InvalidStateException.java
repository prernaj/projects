package com.example.exceptions;

public class InvalidStateException extends RuntimeException {
    public InvalidStateException() {

    }
    public InvalidStateException(String msg) {
        super(msg);
    }
    
}
