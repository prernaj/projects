package com.example.api;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.model.Movie;
import com.example.model.Screen;
import com.example.model.Seat;
import com.example.model.Show;
import com.example.services.MovieService;
import com.example.services.SeatAvailabilityService;
import com.example.services.ShowService;
import com.example.services.TheatreService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class ShowController {
    private final SeatAvailabilityService seatAvailabilityService;
    private final ShowService showService;
    private final TheatreService theatreService;
    private final MovieService movieService;

    public String createShow(@NonNull final String movieId, @NonNull final String screenId, @NonNull final Date startTime,
                             @NonNull final Integer durationInSeconds) {
        final Screen screen = theatreService.getScreen(screenId);
        final Movie movie = movieService.getMovie(movieId);
        return showService.createShow(movie, screen, startTime, durationInSeconds).getId();
    }

    public List<String> getAvailableSeats(@NonNull final String showId) {
        final Show show = showService.getShow(showId);
        final List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::getId).collect(Collectors.toList());
    }
}