package com.example.algorithms.exceptions;

public class NoSuchElementException extends RuntimeException {
    public NoSuchElementException() {

    }

    public NoSuchElementException(String msg) {
        super(msg);
    }
    
}
