package com.example.MovieService.controller;

import com.example.MovieService.Enum.Genre;
import com.example.MovieService.Enum.Language;
import com.example.MovieService.dto.MovieDto;
import com.example.MovieService.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // create movie
    @PostMapping("/")
    public ResponseEntity<MovieDto> createMovies(@Valid @RequestBody MovieDto movieDto) {
        MovieDto createdMovie = movieService.createMovie(movieDto);
        return ResponseEntity.ok(createdMovie);
    }

    // get movie by id
    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable String movieId){
        MovieDto movieById = movieService.getMovieById(movieId);
        return ResponseEntity.ok(movieById);
    }

    // get all movies
    @GetMapping("/")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        List<MovieDto> movieList = movieService.getAllMovies();
        return ResponseEntity.ok(movieList);
    }

    // delete movie

    @DeleteMapping("/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable String movieId) {
        boolean deleted = movieService.deleteMovie(movieId);
        if (deleted) {
            return ResponseEntity.ok("Movie deleted successfully....");
        } else {
            return ResponseEntity.badRequest().body("Movie not found with id : " + movieId);
        }
    }

    // update movie

    @PutMapping ("/{movieId}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable String movieId,@RequestBody MovieDto movieDto){
        MovieDto updatedMovie = movieService.updateMovie(movieId, movieDto);
        return ResponseEntity.ok(updatedMovie);
    }

    // search movie by name
    @GetMapping("/searchByName")
    public ResponseEntity<List<MovieDto>> findMoviesByName(@RequestParam String movieName) {
        List<MovieDto> movieList = movieService.findMoviesByName(movieName);
        return ResponseEntity.ok(movieList);
    }

    // search movie by language

    @GetMapping("/searchByLanguage")
    public ResponseEntity<List<MovieDto>> findMoviesByLanguage(@RequestParam String language ) {
        List<MovieDto> movieList = movieService.findMoviesByLanguage(Language.valueOf(language));
        return ResponseEntity.ok(movieList);
    }

    // search movie by category
    @GetMapping("/searchByCategory")
    public ResponseEntity<List<MovieDto>> findMoviesByCategory(@RequestParam String category) {
        List<MovieDto> movieList = movieService.findMoviesByCategory(Genre.valueOf(category));
        return ResponseEntity.ok(movieList);
    }

    // search movie with keyword

    @GetMapping("/searchByKeyword")
    public ResponseEntity<List<MovieDto>> searchMoviesByKeyword(@RequestParam String keyword) {
        List<MovieDto> movieList = movieService.searchMoviesByKeyword(keyword);
        return ResponseEntity.ok(movieList);
    }

    // search by language,category,movie name
    @GetMapping("/search")
    public ResponseEntity<List<MovieDto>> searchMovies(
            @RequestParam(required = false) String movieName,
            @RequestParam(required = false) Genre category,
            @RequestParam(required = false) Language language
    ) {
        List<MovieDto> movieList = movieService.searchMovies(movieName, category, language);
        return ResponseEntity.ok(movieList);
    }

}
