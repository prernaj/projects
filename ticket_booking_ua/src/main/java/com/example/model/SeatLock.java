package com.example.model;

import java.sql.Date;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SeatLock {
    Seat seat;
    Show show;
    Integer timeoutInSeconds;
    Date lockTime;
    String lockedBy;

    public boolean isLockExpired() {
        Instant lockInstant = lockTime.toInstant().plusSeconds(timeoutInSeconds);
        Instant currentInstant = new Date(timeoutInSeconds).toInstant();
        return lockInstant.isBefore(currentInstant);
    }

}
