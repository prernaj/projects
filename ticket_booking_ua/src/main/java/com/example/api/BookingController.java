package com.example.api;

import java.util.List;
import java.util.stream.Collectors;

import com.example.model.Seat;
import com.example.model.Show;
import com.example.services.BookingService;
import com.example.services.ShowService;
import com.example.services.TheatreService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookingController {
    ShowService showService;
    BookingService bookingService;
    TheatreService theatreService;

    public String createBooking(String userId, String showId, List<String> seatIds) {
        Show show = showService.getShow(showId);
        List<Seat> seats = seatIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userId, show, seats).getId();
    }
}
