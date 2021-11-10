package com.example.providers;

import java.util.List;

import com.example.model.Seat;
import com.example.model.Show;

public interface SeatLockProvider {
    void lockSeats(Show show, List<Seat> seats, String user);
    void unlockSeats(Show show, List<Seat> seats, String user);
    boolean validateLock(Show show, Seat seat, String user);
    List<Seat> getLockedSeats(Show show);
}
