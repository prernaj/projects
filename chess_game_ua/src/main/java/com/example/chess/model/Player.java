package com.example.chess.model;

import java.util.List;

import com.example.chess.exceptions.PieceNotFoundException;
import com.example.gameplay.contracts.PlayerMove;

import lombok.Getter;

/**
 * Abstract model class representing a player.
 * This ia abstract because we are not sure how player is going to make his move.
 * If a player is a local player, then he can move locally.
 * A player can also be a network based player.
 * So, depending on the type of player, he can make his own move.
 */
@Getter
public abstract class Player {
    List<Piece> pieces;

    public Player(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public Piece getPiece(PieceType pieceType) {
        for (Piece piece: pieces) {
            if (piece.getPieceType() == pieceType) {
                return piece;
            }
        }
        throw new PieceNotFoundException();
    }

    abstract public PlayerMove makeMove();
    
}
