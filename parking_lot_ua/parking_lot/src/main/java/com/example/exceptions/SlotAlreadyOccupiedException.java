package com.example.exceptions;

public class SlotAlreadyOccupiedException extends RuntimeException {
    public SlotAlreadyOccupiedException() {

    }

    public SlotAlreadyOccupiedException(String msg) {
        super(msg);
    }
    
}
