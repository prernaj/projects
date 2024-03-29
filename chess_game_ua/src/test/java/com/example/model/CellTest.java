package com.example.model;

package com.example.chess.model;

import com.example.chess.helpers.TestHelpers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void testFreeCell() {
        Cell cell = new Cell(0, 0);
        assertTrue(cell.isFree());
    }

    @Test
    void testOccupiedCell() {
        Cell cell = new Cell(0, 0);
        cell.setCurrentPiece(TestHelpers.randomPiece());
        assertFalse(cell.isFree());
    }
}
