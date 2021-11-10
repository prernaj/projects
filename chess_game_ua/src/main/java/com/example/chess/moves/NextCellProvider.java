package com.example.chess.moves;

import com.example.chess.model.Cell;

/**
 * given a cell, it will provide next cell which we can reach to.
 */
public interface NextCellProvider {
    Cell nextCell(Cell cell);
}
