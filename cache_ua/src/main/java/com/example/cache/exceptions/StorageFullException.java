package com.example.cache.exceptions;

public class StorageFullException extends RuntimeException {
    public StorageFullException() {

    }

    public StorageFullException(String msg) {
        super(msg);
    }
}
