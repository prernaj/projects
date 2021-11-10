package com.example.services;

import java.util.HashMap;
import java.util.Map;

import com.example.exceptions.BadRequstException;
import com.example.model.Booking;
import com.example.providers.SeatLockProvider;

public class PaymentsService {
    Map<Booking, Integer> bookingFailures;
    private final Integer allowedRetries;
    private final SeatLockProvider seatLockProvider;

    public PaymentsService(Integer allowedRetries, SeatLockProvider seatLockProvider) {
        this.bookingFailures = new HashMap<>();
        this.allowedRetries = allowedRetries;
        this.seatLockProvider = seatLockProvider;
    }

    public void processPaymentFailure(Booking booking, String user) {
        if (!booking.getUser().equals(user)) {
            throw new BadRequstException();
        }
        if (!bookingFailures.containsKey(booking)) {
            bookingFailures.put(booking, 0);
        }
        final Integer currentFailureCounts = bookingFailures.get(booking);
        final Integer newFailuresCount = currentFailureCounts + 1;
        bookingFailures.put(booking, newFailuresCount);
        if (newFailuresCount > allowedRetries) {
            seatLockProvider.unlockSeats(booking.getShow(), booking.getSeatsBooked(), booking.getUser());
        }

    }
    
}
