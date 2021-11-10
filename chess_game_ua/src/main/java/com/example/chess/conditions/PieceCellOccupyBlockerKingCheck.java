package com.example.chess.conditions;

import com.example.chess.model.Board;
import com.example.chess.model.Cell;
import com.example.chess.model.Piece;
import com.example.chess.model.Player;

/**
 * This tells whether making piece move to a cell will attract check for king.
 */
public class PieceCellOccupyBlockerKingCheck implements PieceCellOccupyBlocker {
    @Override
    public boolean isCellNonOccupiableForPiece(final Cell cell, final Piece piece, final Board board, Player player) {
        Cell pieceOriginalCell = piece.getCurrentCell();
        piece.setCurrentCell(cell);
        boolean playerGettingCheckByMove = board.isPlayerOnCheck(player);
        piece.setCurrentCell(pieceOriginalCell);
        return playerGettingCheckByMove;
    }
}
