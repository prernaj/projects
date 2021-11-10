package com.example.chess.exceptions;

public class PieceNotFoundException extends RuntimeException {
    public PieceNotFoundException() {

    }

    public PieceNotFoundException(String msg) {
        super(msg);
    }
}
