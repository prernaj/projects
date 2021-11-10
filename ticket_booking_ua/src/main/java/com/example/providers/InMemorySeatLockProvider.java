package com.example.providers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.exceptions.SeatTemporaryUnavailableException;
import com.example.model.Seat;
import com.example.model.SeatLock;
import com.example.model.Show;
import com.google.common.collect.ImmutableList;

public class InMemorySeatLockProvider implements SeatLockProvider {
    Integer lockTimeout;
    Map<Show, Map<Seat, SeatLock>> locks;

    public InMemorySeatLockProvider(Integer lockTimeout) {
        this.lockTimeout = lockTimeout;
        this.locks = new HashMap<>();
    }

    @Override
    synchronized public void lockSeats(Show show, List<Seat> seats, String user) {
        for (Seat seat: seats) {
            if (isSeatLocked(show, seat)) {
                throw new SeatTemporaryUnavailableException();
            }
        }
        for (Seat seat: seats) {
            lockSeat(show, seat, user, lockTimeout);
        }
        
    }

    @Override
    synchronized public void unlockSeats(Show show, List<Seat> seats, String user) {
        for (Seat seat: seats) {
            if (validateLock(show, seat, user)) {
                unlockSeat(show, seat);
            }
        }
    }

    @Override
    public boolean validateLock(Show show, Seat seat, String user) {
        return isSeatLocked(show, seat) && locks.get(show).get(seat).getLockedBy().equals(user);
    }


    @Override
    public List<Seat> getLockedSeats(Show show) {
        if (!locks.containsKey(show)) {
            return ImmutableList.of();
        }
        final List<Seat> lockedSeats = new ArrayList<>();
        for (Seat seat : locks.get(show).keySet()) {
            if (isSeatLocked(show, seat)) {
                lockedSeats.add(seat);
            }
        }
        return lockedSeats;
    }

    private void unlockSeat(Show show, Seat seat) {
        if (!locks.containsKey(show)) {
            return;
        }
        locks.get(show).remove(seat);
    }

    private void lockSeat(Show show, Seat seat, String user, Integer timeoutInSeconds) {
        if (!locks.containsKey(show)) {
            locks.put(show, new HashMap<>());
        }
        SeatLock lock = new SeatLock(seat, show, timeoutInSeconds, (java.sql.Date) new Date(), user);
        locks.get(show).put(seat, lock);
    }

    private boolean isSeatLocked(Show show, Seat seat) {
        return locks.containsKey(show) && locks.get(show).containsKey((seat)) && !locks.get(show).get(seat).isLockExpired();
    }
    
}
