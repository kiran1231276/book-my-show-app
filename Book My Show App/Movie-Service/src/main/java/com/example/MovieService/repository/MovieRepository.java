package com.example.MovieService.repository;

import com.example.MovieService.Enum.Genre;
import com.example.MovieService.Enum.Language;
import com.example.MovieService.dto.MovieDto;
import com.example.MovieService.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    List<Movie> findByMovieName(String movieName);

    List<Movie> findMovieByLanguage(Language language);

    List<Movie> findMovieByCategory(Genre category);

    List<Movie> findByMovieNameAndCategoryAndLanguage(String movieName, Genre category, Language language);
    @Query("SELECT m FROM Movie m WHERE LOWER(m.movieName) LIKE %:keyword%")
    List<Movie> searchMoviesByKeyword(@Param("keyword") String keyword);
}
