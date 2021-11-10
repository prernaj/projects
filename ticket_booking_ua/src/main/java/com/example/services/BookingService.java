package com.example.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.exceptions.BadRequstException;
import com.example.exceptions.NotFoundException;
import com.example.exceptions.SeatPermanentlyUnavailableException;
import com.example.model.Booking;
import com.example.model.Seat;
import com.example.model.Show;
import com.example.providers.SeatLockProvider;

public class BookingService {
    Map<String, Booking> showBooking;
    SeatLockProvider seatLockProvider;

    public BookingService(SeatLockProvider seatLockProvider) {
        this.seatLockProvider = seatLockProvider;
        this.showBooking = new HashMap<>();
    }

    public Booking getBooking(String bookingId) {
        if (!showBooking.containsKey(bookingId)) {
            throw new NotFoundException();
        }
        return showBooking.get(bookingId);
    }

    public List<Booking> getAllBookings(Show show) {
        List<Booking> response = new ArrayList<>();
        for (Booking booking : showBooking.values()) {
            if (booking.getShow().equals(show)) {
                response.add(booking);
            }
        }

        return response;
    }

    public Booking createBooking(String userId, Show show, List<Seat> seats) {
        if (isAnySeatAlreadyBooked(show, seats)) {
            throw new SeatPermanentlyUnavailableException();
        }
        seatLockProvider.lockSeats(show, seats, userId);
        final String bookingId = UUID.randomUUID().toString();
        final Booking newBooking = new Booking(bookingId, show, userId, seats);
        showBooking.put(bookingId, newBooking);
        return newBooking;
    }

    public List<Seat> getBookedSeats(Show show) {
        return getAllBookings(show).stream()
                .filter(Booking::isConfirmed)
                .map(Booking::getSeatsBooked)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public void confirmBooking(Booking booking, String user) {
        if (!booking.getUser().equals(user)) {
            throw new BadRequstException();
        }
        for (Seat seat: booking.getSeatsBooked()) {
            if (!seatLockProvider.validateLock(booking.getShow(), seat, user)) {
                throw new BadRequstException();
            }
        }
        booking.confirmBooking();
    }

    private boolean isAnySeatAlreadyBooked(Show show, List<Seat> seats) {
        final List<Seat> bookedSeats = getBookedSeats(show);
        for (Seat seat : seats) {
            if (bookedSeats.contains(seat)) {
                return true;
            }
        }
        return false;
    }



    
    
}
