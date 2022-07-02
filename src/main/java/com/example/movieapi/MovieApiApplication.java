package com.example.movieapi;

import com.example.movieapi.model.Movie;
import com.example.movieapi.repository.MovieRepository;
import org.bson.codecs.jsr310.LocalDateTimeCodec;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class MovieApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApiApplication.class, args);
	}


/*	@Bean
	CommandLineRunner runner(MovieRepository repository){
		return args -> {

			Stream.of("Mike","Hector","Job").forEach(name->{
				Movie.Comment comment=new Movie.Comment(name,"Great Movie", LocalDateTime.now());
			});

			Movie movie = new Movie();
			movie.setTitle("Godfather");
			movie.setDirector("Francis Ford Coppola");
			movie.setYear("1972");
			movie.setPoster("https://www.imdb.com/title/tt0068646/");
		repository.insert(movie);
		};
	}*/
}
