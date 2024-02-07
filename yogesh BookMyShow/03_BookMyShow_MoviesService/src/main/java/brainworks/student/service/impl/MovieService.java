package brainworks.student.service.impl;

import brainworks.student.payload.MovieDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> getAllMovies();

    List <MovieDto> findMovieByContaining(String contains);

    MovieDto createMovie(MovieDto movieDto);

    Boolean deleteMovie(String movieId);

    MovieDto findMovieById(String movieId);
}
