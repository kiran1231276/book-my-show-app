package com.example.MovieService.service;

import com.example.MovieService.Enum.Genre;
import com.example.MovieService.Enum.Language;
import com.example.MovieService.dto.MovieDto;
import java.util.List;

public interface MovieService {

    public MovieDto createMovie(MovieDto movieDto);

    public MovieDto getMovieById(String movieId);

    public List<MovieDto> getAllMovies();

    public boolean deleteMovie(String movieId);

    public MovieDto updateMovie(String movieId,MovieDto movieDto);

    public List<MovieDto> findMoviesByName(String movieName);

    public List<MovieDto> findMoviesByLanguage(Language language);

    public List<MovieDto> findMoviesByCategory(Genre category);

    List<MovieDto> searchMovies(String movieName, Genre category, Language language);

    List<MovieDto> searchMoviesByKeyword(String keyword);
}
