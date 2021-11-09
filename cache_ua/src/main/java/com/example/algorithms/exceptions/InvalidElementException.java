package com.example.algorithms.exceptions;

public class InvalidElementException extends RuntimeException {
    public InvalidElementException() {

    }

    public InvalidElementException(String msg) {
        super(msg);
    }
    
}
