package com.example.movieapi.service;

import com.example.movieapi.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {

    Movie validateAndGetMovie(String imdbId);

    List<Movie> getMovies();

    Movie saveMovie(Movie movie);

    void deleteMovie(Movie movie);
}