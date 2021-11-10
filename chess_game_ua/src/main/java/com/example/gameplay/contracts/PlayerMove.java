package com.example.gameplay.contracts;

import com.example.chess.model.Cell;
import com.example.chess.model.Piece;

import lombok.Getter;

@Getter
public class PlayerMove {
    Piece piece;
    Cell toCell;
}
