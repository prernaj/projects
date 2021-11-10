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


public class PossibleMovesProviderHorizontal extends PossibleMovesProvider {
    public PossibleMovesProviderHorizontal(int maxSteps, MoveBaseCondition moveBaseCondition, PieceMoveFurtherCondition pieceMoveFurtherCondition, PieceCellOccupyBlocker pieceCellOccupyBlocker) {
        super(maxSteps, moveBaseCondition, pieceMoveFurtherCondition, pieceCellOccupyBlocker);
    }

    @Override
    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, final Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        List<Cell> result = new ArrayList<>();
        result.addAll(findAllNextMoves(piece, board::getLeftCell, board, additionalBlockers, player));
        result.addAll(findAllNextMoves(piece, board::getRightCell, board, additionalBlockers, player));
        return result;
    }
}
