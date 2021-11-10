package com.example.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.example.exceptions.NotFoundException;
import com.example.exceptions.ScreenAlreadyOccupiedException;
import com.example.model.Movie;
import com.example.model.Screen;
import com.example.model.Show;

public class ShowService {
    private final Map<String, Show> shows;
    
    public ShowService() {
        this.shows = new HashMap<>();
    }

    public Show getShow(String showId) {
        if (!shows.containsKey(showId)) {
            throw new NotFoundException();
        }
        return shows.get(showId);
    }

    public Show createShow(Movie movie, Screen screen, Date startTime, Integer durationInSeconds) {
        if (!checkIfShowCreationIsAllowed(screen, startTime, durationInSeconds)) {
            throw new ScreenAlreadyOccupiedException();
        }
        String showId =  UUID.randomUUID().toString();
        final Show show = new Show(showId, movie, screen, startTime, durationInSeconds);
        this.shows.put(showId, show);
        return show;
    }

    private List<Show> getShowsForScreen(final Screen screen) {
        final List<Show> response = new ArrayList<>();
        for (Show show : shows.values()) {
            if (show.getScreen().equals(screen)) {
                response.add(show);
            }
        }
        return response;
    }

    private boolean checkIfShowCreationIsAllowed(Screen screen, Date startTime, Integer durationInMinutes) {
        // TODO: Implement this. This method will return whether the screen is free at a particular time for
        // specific duration. This function will be helpful in checking whether the show can be scheduled in that slot
        // or not.
        return true;
    }

}
