package com.example.chess.moves;

import java.util.List;

import com.example.chess.conditions.MoveBaseCondition;
import com.example.chess.conditions.PieceCellOccupyBlocker;
import com.example.chess.conditions.PieceMoveFurtherCondition;
import com.example.chess.model.Board;
import com.example.chess.model.Cell;
import com.example.chess.model.Piece;
import com.example.chess.model.Player;


public class PossileMovesProviderDiagonal extends PossibleMovesProvider {
    public PossileMovesProviderDiagonal(int maxSteps, MoveBaseCondition baseCondition, PieceMoveFurtherCondition moveFurtherCondition, PieceCellOccupyBlocker baseBlocker) {
        super(maxSteps, baseCondition, moveFurtherCondition, baseBlocker);
    }

    @Override
    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        return null;
    }

}
