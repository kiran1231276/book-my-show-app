package brainworks.student.service.impl;

import brainworks.student.entity.Movie;
import brainworks.student.exception.ResourceNotFoundException;
import brainworks.student.payload.MovieDto;
import brainworks.student.repository.MoviesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    MoviesRepository moviesRepository;
    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movieList = moviesRepository.findAll ();
        List<MovieDto> movieDtoList=new ArrayList<> ();
        movieList.stream ().map (movie -> {
            MovieDto movieDto = new MovieDto ();
            BeanUtils.copyProperties (movie, movieDto);
            movieDtoList.add (movieDto);
            return movie;
        }).collect (Collectors.toList ());
        return movieDtoList;
    }

    @Override
    public List<MovieDto> findMovieByContaining(String contains) {
        List<MovieDto>movieDtoList=new ArrayList<> ();
        List<Movie> byNameContaining = moviesRepository.findByNameContaining (contains);
        List<Movie> byCategoryContaining = moviesRepository.findByCategoryContaining (contains);
        extracted (byNameContaining, movieDtoList, byCategoryContaining);
        List<MovieDto> listOfMovies = movieDtoList.stream ().distinct ().collect (Collectors.toList ());
         return listOfMovies;
    }

    private static void extracted(List<Movie> byNameContaining, List<MovieDto> movieDtoList, List<Movie> byCategoryContaining) {
        byNameContaining.stream ().map (movie -> {
            MovieDto movieDto = new MovieDto ();
            BeanUtils.copyProperties (movie, movieDto);
            movieDtoList.add (movieDto);
            return movie;
        }).collect (Collectors.toList ());
        byCategoryContaining.stream ().map (movie -> {
            MovieDto movieDto = new MovieDto ();
            BeanUtils.copyProperties (movie, movieDto);
            movieDtoList.add (movieDto);
            return movie;
        }).collect (Collectors.toList ());
    }

    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        movieDto.setMovieId (UUID.randomUUID ().toString ());
        Movie movie=new Movie ();
        BeanUtils.copyProperties (movieDto,movie);
        Movie saved = moviesRepository.save (movie);
        BeanUtils.copyProperties (saved,movieDto);
        return movieDto;
    }

    @Override
    public Boolean deleteMovie(String movieId) {
        Movie movie = moviesRepository.findById (movieId)
                .orElseThrow (() -> new ResourceNotFoundException ("Movie", "movieId", movieId));
        moviesRepository.delete (movie);
        return movie != null;
    }

    @Override
    public MovieDto findMovieById(String movieId) {
        Movie movie = moviesRepository.findById (movieId)
                .orElseThrow (() -> new ResourceNotFoundException ("Movie", "MovieId", movieId));
        MovieDto movieDto=new MovieDto ();
        BeanUtils.copyProperties (movie,movieDto);
        return movieDto;
    }


}
