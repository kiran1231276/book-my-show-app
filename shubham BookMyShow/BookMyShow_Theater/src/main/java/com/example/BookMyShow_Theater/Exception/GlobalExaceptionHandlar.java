package com.example.BookMyShow_Theater.Exception;


import com.example.BookMyShow_Theater.ApiConstant.ApiRespones;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExaceptionHandlar {


    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiRespones> resourceNotFoundExceptionHandlar(ResourceNotFoundException ex){
     String msg= ex.getMessage();
     ApiRespones apiRespones= ApiRespones.builder()
             .msg(msg)
             .build();
     return new ResponseEntity<>(apiRespones, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodNotFoundExceptionHandler(MethodArgumentNotValidException ex){

        Map<String,String> handel= new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName= ((FieldError)error).getField();
            String message= error.getDefaultMessage();
            handel.putIfAbsent(fieldName,message);

        });
        return new ResponseEntity<Map<String,String>>(handel,HttpStatus.BAD_REQUEST);


    }



}
