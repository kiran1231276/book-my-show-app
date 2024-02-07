package com.example.MovieService.Enum;

public enum Language {
    ENGLISH("English"),
    HINDI("Hindi"),
    PUNJABI("Punjabi"),
    TELUGU("Telugu"),
    MALAYALAM("Malayalam"),
    TAMIL("Tamil"),
    MARATHI("Marathi"),
    BHOJPURI("Bhojpuri"),
    KANNADA("Kannda");

    private final String displayName;

    Language(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
