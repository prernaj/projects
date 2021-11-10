package com.example.chess.moves;

import java.util.ArrayList;
import java.util.List;

import com.example.chess.conditions.MoveBaseCondition;
import com.example.chess.conditions.PieceCellOccupyBlocker;
import com.example.chess.conditions.PieceMoveFurtherCondition;
import com.example.chess.model.Board;
import com.example.chess.model.Cell;
import com.example.chess.model.Piece;
import com.example.chess.model.Player;

import lombok.AllArgsConstructor;

/**
 * Provider class which returns all the possible cells for a given type of moves.
 * For example, horizontal type of move will give all the cells which can be reached by making only horizontal moves.
 */

public abstract class PossibleMovesProvider {
    int maxSteps;
    MoveBaseCondition baseCondition;
    PieceMoveFurtherCondition moveFurtherCondition;
    PieceCellOccupyBlocker baseBlocker;

    public PossibleMovesProvider(int maxSteps, MoveBaseCondition moveBaseCondition, PieceMoveFurtherCondition pieceMoveFurtherCondition, PieceCellOccupyBlocker pieceCellOccupyBlocker) {
        this.maxSteps = maxSteps;
        this.baseCondition = moveBaseCondition;
        this.moveFurtherCondition = moveFurtherCondition;
        this.baseBlocker = pieceCellOccupyBlocker;
    }

    /**
     * Public method which actually gives all possible cells which can be reahed via current type of move.
     */
    public List<Cell> possibleMoves(Piece piece, Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        if (baseCondition.isBaseConditionFullfilled(piece)) {
            return possibleMovesAsPerCurrentType(piece, board, additionalBlockers, player);
        }
        return null;
    }

    /**
     * Abstract method which needs to be implemented by each type of move to give possible moves as per their behavior.
     * @param piece
     * @param board
     * @param additionalBlockers
     * @param player
     * @return
     */
    protected abstract List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player);

    /**
     * Helper method used by all the subtypes to create the list of cells which can be reached.
     * @param piece
     * @param nextCellProvider
     * @param board
     * @param cellOccupyBlockers
     * @param player
     * @return
     */
    protected List<Cell> findAllNextMoves(Piece piece, NextCellProvider nextCellProvider, Board board, List<PieceCellOccupyBlocker> cellOccupyBlockers, Player player) {
        List<Cell> result = new ArrayList<>();
        Cell nextCell = nextCellProvider.nextCell(piece.getCurrentCell());
        int numSteps = 1;
        while(nextCell != null && numSteps <= maxSteps) {
            if (checkIfCellCanBeOccupied(piece, nextCell, board, cellOccupyBlockers, player)) {
                result.add(nextCell);
            }
            if (!moveFurtherCondition.canPieceMoveFurtherFromCell(piece, nextCell, board)) {
                break;
            }
            nextCell = nextCellProvider.nextCell(nextCell);
            numSteps++;
        }
        return result;
    }

    /**
     * Helper method which checks if a given cell can be occupied by the piece or not.
     * It makes use of list of {@link PieceCellOccupyBlocker}'s passed to it while checking.
     * Also each move has one base blocker which it should also check.
     * @param piece
     * @param cell
     * @param board
     * @param additionalBlockers
     * @param player
     * @return
     */
    private boolean checkIfCellCanBeOccupied(Piece piece, Cell cell, Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        if (baseBlocker != null && baseBlocker.isCellNonOccupiableForPiece(cell, piece, board, player)) {
            return false;
        }
        for (PieceCellOccupyBlocker cellOccupyBlocker: additionalBlockers) {
            if (cellOccupyBlocker.isCellNonOccupiableForPiece(cell, piece, board, player)) {
                return false;
            }
        }
        return true;
    }
    
}
