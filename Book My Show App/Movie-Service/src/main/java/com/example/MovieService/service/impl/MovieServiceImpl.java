package com.example.MovieService.service.impl;

import com.example.MovieService.Enum.Genre;
import com.example.MovieService.Enum.Language;
import com.example.MovieService.dto.MovieDto;
import com.example.MovieService.entity.Movie;
import com.example.MovieService.exception.MovieNotFoundException;
import com.example.MovieService.repository.MovieRepository;
import com.example.MovieService.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        movieDto.setMovieId(UUID.randomUUID().toString());
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieDto, movie);
        Movie savedMovie = movieRepository.save(movie);
        return mapMovieToDto(savedMovie);
    }

    @Override
    public MovieDto getMovieById(String movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if(optionalMovie.isPresent()){
            return mapMovieToDto(optionalMovie.get());
        }
        else {
            throw new MovieNotFoundException("Movie with given id is not found : " + movieId);
        }
    }

    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movieList = movieRepository.findAll();
        return movieList.stream()
                .map(this::mapMovieToDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteMovie(String movieId) {
        return movieRepository.findById(movieId).map(movie -> {
            movieRepository.delete(movie);
            return true;
        }).orElse(false);
    }

    @Override
    public MovieDto updateMovie(String movieId, MovieDto movieDto) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if(optionalMovie.isPresent()){
            Movie existingMovie = optionalMovie.get();
            BeanUtils.copyProperties(movieDto,existingMovie,"movieId");
            Movie savedMovie = movieRepository.save(existingMovie);
            return mapMovieToDto(savedMovie);
        }
        else{
            throw new MovieNotFoundException("Movie with given id is not found :"+movieId);
        }
    }

    @Override
    public List<MovieDto> findMoviesByName(String movieName) {
        List<Movie> movieList = movieRepository.findByMovieName(movieName);
        return movieList.stream()
                .map(this::mapMovieToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findMoviesByLanguage(Language language) {
        List<Movie> movieList = movieRepository.findMovieByLanguage(language);
        return movieList.stream()
                .map(this::mapMovieToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findMoviesByCategory(Genre category) {
        List<Movie> movieList = movieRepository.findMovieByCategory(category);
        return movieList.stream()
                .map(this::mapMovieToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> searchMovies(String movieName, Genre category, Language language) {
        List<Movie> movieList = movieRepository.findByMovieNameAndCategoryAndLanguage(movieName, category, language);
        return movieList.stream()
                .map(this::mapMovieToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> searchMoviesByKeyword(String keyword) {
        List<Movie> movieList = movieRepository.searchMoviesByKeyword(keyword.toLowerCase());
        return movieList.stream()
                .map(this::mapMovieToDto)
                .collect(Collectors.toList());
    }

    // Helper method to map movie entity to movieDto

    private MovieDto mapMovieToDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        BeanUtils.copyProperties(movie, movieDto);
        return movieDto;
    }

    // Helper method to set field Dynamically using Reflection utils

    private void setField(Movie movie,String fieldName,Object value){
        Optional.ofNullable(org.springframework.util.ReflectionUtils.findField(Movie.class,fieldName))
                .ifPresent(field -> {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field,movie,value);
                });
    }

}
