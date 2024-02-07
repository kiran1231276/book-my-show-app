package com.example.ShowTimeService.service;

import com.example.ShowTimeService.dto.ShowTimeDto;

import java.util.List;
import java.util.Map;

public interface ShowTimeService {

    ShowTimeDto createShowTime(ShowTimeDto showTimeDto);

    ShowTimeDto updateShowTime(String showTimeId, ShowTimeDto showTimeDto);

    ShowTimeDto updateSpecificFieldOfShowTime(String showTimeId, Map<String, Object> fields);

    ShowTimeDto getShowTimeById(String showTimeId);

    List<ShowTimeDto> getAllShowTime ();

    ShowTimeDto getAvailableSeats(String showTimeId);









//    // Get all show times for a specific movie
//    List<ShowTimeDto> getShowTimesByMovieId(String movieId);

    // Get all show times for a specific cinema hall
   // List<ShowTimeDto> getShowTimesByCinemaHallId(String hallId);



    // Get details of a show time, including associated movie and cinema hall information
    //ShowTimeDetailsDto getShowTimeDetails(String showTimeId);
}
