package com.example.movieapi.mapper;

import com.example.movieapi.controller.dto.MovieDto;
import com.example.movieapi.model.Movie;
import com.example.movieapi.service.UserExtraService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = UserExtraService.class
)
public abstract class MovieMapper {

    @Autowired
    protected UserExtraService userExtraService;

    @Mapping(target = "comments", ignore = true)
    //public abstract Movie toMovie(CreateMovieRequest createMovieRequest);

    @Mapping(target = "imdbId", ignore = true)
    @Mapping(target = "comments", ignore = true)
    //public abstract void updateMovieFromDto(UpdateMovieRequest updateMovieRequest, @MappingTarget Movie movie);

    public abstract MovieDto toMovieDto(Movie movie);

    @Mapping(
            target = "avatar",
            expression = "java( userExtraService.getUserExtra(comment.getUsername()).isPresent() ? userExtraService.getUserExtra(comment.getUsername()).get().getAvatar() : comment.getUsername() )"
    )
    public abstract MovieDto.CommentDto toMovieDtoCommentDto(Movie.Comment comment);
}