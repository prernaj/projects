package com.example.chess.exceptions;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException() {

    }
    public InvalidMoveException(String msg) {
        super(msg);
    }    
}
