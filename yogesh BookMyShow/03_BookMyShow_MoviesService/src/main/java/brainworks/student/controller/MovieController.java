package brainworks.student.controller;

import brainworks.student.payload.MovieDto;

import brainworks.student.service.impl.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        List<MovieDto> allMovies = movieService.getAllMovies ();
        return new ResponseEntity<> (allMovies, HttpStatus.OK);
    }

    @GetMapping("/searchMovies/{contains}")
    public ResponseEntity<List<MovieDto>> searchMovies(@PathVariable String contains) {
        List<MovieDto> allMovies = movieService.findMovieByContaining (contains);
        return new ResponseEntity<> (allMovies, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    public ResponseEntity<String> deleteMovies(@PathVariable String movieId) {
        Boolean isDeleted = movieService.deleteMovie (movieId);
        if (isDeleted) return new ResponseEntity<> ("Movie deleted !!!!", HttpStatus.OK);
        else return new ResponseEntity<> ("Request failed !!!!", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<MovieDto> createMovies(@Valid @RequestBody MovieDto movieDto) {
        MovieDto movie = movieService.createMovie (movieDto);
        return new ResponseEntity<> (movieDto, HttpStatus.CREATED);
    }

    @GetMapping("/getMovie/{movieId}")
    public ResponseEntity<MovieDto> findMovieById(@PathVariable String movieId) {
        MovieDto movieDto = movieService.findMovieById (movieId);
        return new ResponseEntity<> (movieDto, HttpStatus.OK);
    }
}

