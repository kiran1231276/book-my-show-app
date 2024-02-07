package com.example.MovieService.dto;

import com.example.MovieService.Enum.Genre;
import com.example.MovieService.Enum.Language;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDto {

    private String movieId;

    @NotBlank
    @Size(min = 2, message = "At least 2 characters expected!!!")
    private String movieName;

    @NotNull
    private LocalDate releaseDate;

    @NotNull
    private Genre category;

    @NotNull
    @NotEmpty
    private List<String> genre;

    @NotNull
    @NotBlank
    private String ratings;

    @NotNull
    private LocalTime duration;

    @NotNull
    private Language language;

    @NotNull
    @NotBlank
    private String country;

    @NotNull
    @NotBlank
    private String poster;
}
