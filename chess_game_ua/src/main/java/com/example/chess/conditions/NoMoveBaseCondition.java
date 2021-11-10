package com.example.chess.conditions;

import com.example.chess.model.Piece;

/**
 * Helper implementation to use when there is no associated base condition with a move.
 * 
 */
public class NoMoveBaseCondition {
    public boolean isBaseConditionFullfilled(Piece piece) {
        return true;
    }
}
