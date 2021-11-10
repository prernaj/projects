package com.example.api;

import com.example.services.MovieService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MovieController {
    final private MovieService movieService;
    
    public String createMovie(String movieName) {
        return movieService.createMovie(movieName).getId();
    }
}
