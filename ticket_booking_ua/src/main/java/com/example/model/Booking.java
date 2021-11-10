package com.example.model;

import java.util.List;

import com.example.exceptions.InvalidStateException;

import lombok.Getter;

@Getter
public class Booking {
    String id;
    Show show;
    List<Seat> seatsBooked;
    String user;
    BookingStatus bookingStatus;

    public Booking(String id, Show show, String user, List<Seat> seatsBooked) {
        this.id = id;
        this.show = show;
        this.seatsBooked = seatsBooked;
        this.user = user;
        this.bookingStatus = BookingStatus.Created;
    }

    public boolean isConfirmed() {
        return this.bookingStatus == BookingStatus.Confirmed;
    }

    public void confirmBooking() {
        if (this.bookingStatus != BookingStatus.Created) {
            throw new InvalidStateException();
        }
        this.bookingStatus = BookingStatus.Confirmed;
    }

    public void expireBooking() {
        if (this.bookingStatus != BookingStatus.Created) {
            throw new InvalidStateException();
        }
        this.bookingStatus = BookingStatus.Expired;
    }
}
