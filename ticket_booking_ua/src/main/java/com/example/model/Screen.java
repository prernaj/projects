package com.example.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Screen {
    String id;
    String name;
    Theatre theatre;
    List<Seat> seats;

    public Screen(String id, String name, Theatre theater) {
        this.id = id;
        this.name = name;
        this.theatre = theater;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }
}
