package com.example.movieapi.controller;

import com.example.movieapi.controller.dto.MovieDto;
import com.example.movieapi.mapper.MovieMapper;
import com.example.movieapi.model.Movie;
import com.example.movieapi.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @GetMapping
    public List<MovieDto> getMovies() {
        return movieService.getMovies().stream()
                .map(movieMapper::toMovieDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{imdbId}")
    public MovieDto getMovie(@PathVariable String imdbId) {
        Movie movie = movieService.validateAndGetMovie(imdbId);
        return movieMapper.toMovieDto(movie);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MovieDto createMovie(Movie movie) {
        movie = movieService.saveMovie(movie);
        return movieMapper.toMovieDto(movie);
    }

 /*   @PutMapping("/{imdbId}")
    public MovieDto updateMovie(@PathVariable String imdbId, @Valid @RequestBody UpdateMovieRequest updateMovieRequest) {
        Movie movie = movieService.validateAndGetMovie(imdbId);
        movieMapper.updateMovieFromDto(updateMovieRequest, movie);
        movie = movieService.saveMovie(movie);
        return movieMapper.toMovieDto(movie);
    }*/

    @DeleteMapping("/{imdbId}")
    public MovieDto deleteMovie(@PathVariable String imdbId) {
        Movie movie = movieService.validateAndGetMovie(imdbId);
        movieService.deleteMovie(movie);
        return movieMapper.toMovieDto(movie);
    }

/*    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{imdbId}/comments")
    public MovieDto addMovieComment(@PathVariable String imdbId, @Valid @RequestBody AddCommentRequest addCommentRequest, Principal principal) {
        Movie movie = movieService.validateAndGetMovie(imdbId);
        Movie.Comment comment = new Movie.Comment(principal.getName(), addCommentRequest.getText(), LocalDateTime.now());
        movie.getComments().add(0, comment);
        movie = movieService.saveMovie(movie);
        return movieMapper.toMovieDto(movie);
    }*/
}