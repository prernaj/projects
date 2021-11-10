package com.example.exceptions;

public class ScreenAlreadyOccupiedException extends RuntimeException {
    public ScreenAlreadyOccupiedException() {

    }
    public ScreenAlreadyOccupiedException(String msg) {
        super(msg);
    }
    
}
