package com.example.MovieService.exception;

import com.example.MovieService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(MovieNotFoundException exception){

        String message =  exception.getMessage();
        ApiResponse response = ApiResponse.builder()
                .message(message)
                .success(true)
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
