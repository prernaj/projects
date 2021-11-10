package com.example.exceptions;

public class BadRequstException extends RuntimeException {
    public BadRequstException() {

    }
    public BadRequstException(String msg) {
        super(msg);
    }
    
}
