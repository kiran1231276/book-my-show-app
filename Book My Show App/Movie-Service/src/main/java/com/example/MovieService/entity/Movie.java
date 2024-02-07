package com.example.MovieService.entity;

import com.example.MovieService.Enum.Genre;
import com.example.MovieService.Enum.Language;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "movie_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private String movieId;

    private String movieName;
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private Genre category;

    private LocalTime duration;

    private List<String> genre = new ArrayList<>();

    private String ratings;

    @Enumerated(EnumType.STRING)
    private Language language;  // Using the Language enum instead of String

    private String country;
    private String poster;
}
