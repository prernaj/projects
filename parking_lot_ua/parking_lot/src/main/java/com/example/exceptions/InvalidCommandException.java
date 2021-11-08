package com.example.exceptions;

public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException() {

    }

    public InvalidCommandException(String msg) {
        super(msg);
    }
}
