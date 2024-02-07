package com.example.CinemaHallService.service;

import com.example.CinemaHallService.dto.CinemaHallDto;

import java.util.List;
import java.util.Map;

public interface CinemaHallService {

    // create cinema hall
    CinemaHallDto createCinemaHall(CinemaHallDto cinemaHallDto);

    CinemaHallDto getCinemaHallById(String hallId);

    List<CinemaHallDto> getAllCinemaHalls();

    boolean deleteCinemaHall(String hallId);

    CinemaHallDto updateSpecificFieldOfCinemaHall(String hallId, Map<String, Object> fields);

    List<CinemaHallDto> getCinemaHallsByName(String name);

    List<CinemaHallDto> getCinemaHallsByLocation(String location);

    Integer checkSeatAvailability(String hallId);
}
