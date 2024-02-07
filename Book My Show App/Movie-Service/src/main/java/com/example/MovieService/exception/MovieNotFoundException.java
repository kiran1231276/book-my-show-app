package com.example.MovieService.exception;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String message){
        super(message);
    }
}
