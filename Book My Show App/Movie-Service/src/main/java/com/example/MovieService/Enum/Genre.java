package com.example.MovieService.Enum;

public enum Genre {
    ACTION("Action"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    HORROR("Horror"),
    ROMANCE("Romance"),
    SCIFI("Science Fiction"),
    THRILLER("Thriller"),
    ANIMATION("Animation"),
    FANTASY("Fantasy"),
    DOCUMENTARY("Documentary"),
    OTHER("Other");

    private final String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}