package com.example.chess.conditions;

import com.example.chess.model.Board;
import com.example.chess.model.Cell;
import com.example.chess.model.Piece;

/**
 * Condition interface to tell whether a piece can further move from a cell.
 */
public interface PieceMoveFurtherCondition {
    boolean canPieceMoveFurtherFromCell(Piece piece, Cell cell, Board board);
}
