package com.example.chess.conditions;

import com.example.chess.model.Board;
import com.example.chess.model.Cell;
import com.example.chess.model.Piece;
import com.example.chess.model.Player;

/**
 * This tells that a cell cannot occupy a cell if that cell already has a piece from the same player.
 */
public class PieceCellOccupyBlockerSelfPiece implements PieceCellOccupyBlocker {
    
    @Override
    public boolean isCellNonOccupiableForPiece(Cell cell, Piece piece, Board board, Player player) {
        if (cell.isFree()) {
            return false;
        }
        return cell.getCurrentPiece().getColor() == piece.getColor();
    }
}
