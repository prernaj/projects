package com.example.chess.conditions;

import com.example.chess.model.Board;
import com.example.chess.model.Cell;
import com.example.chess.model.Piece;
import com.example.chess.model.Player;

/**
 * This check tells whether a piece can occupy a given cell in the board or not.
 */
public interface PieceCellOccupyBlocker {
    boolean isCellNonOccupiableForPiece(Cell cell, Piece piece, Board board, Player player);
}
