package com.example.CinemaHallService.controller;

import com.example.CinemaHallService.dto.CinemaHallDto;
import com.example.CinemaHallService.service.CinemaHallService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/cinema-halls")
public class CinemaHallController {

     @Autowired
     private CinemaHallService cinemaHallService;

     @PostMapping("/")
     public ResponseEntity<CinemaHallDto> createCinemaHall(@Valid @RequestBody CinemaHallDto cinemaHallDto){
         CinemaHallDto createdCinemaHall = cinemaHallService.createCinemaHall(cinemaHallDto);
         return new ResponseEntity<>(createdCinemaHall, HttpStatus.CREATED);
     }

     @GetMapping("/{hallId}")
     public ResponseEntity<CinemaHallDto> getCinemaHallById(@PathVariable String hallId){
         CinemaHallDto cinemaHallById = cinemaHallService.getCinemaHallById(hallId);
         return ResponseEntity.ok(cinemaHallById);
     }

    @GetMapping("/")
    public ResponseEntity<List<CinemaHallDto>> getAllCinemaHalls() {
        List<CinemaHallDto> cinemaHallDtoList = cinemaHallService.getAllCinemaHalls();
        return ResponseEntity.ok(cinemaHallDtoList);
    }

    @DeleteMapping("/{hallId}")
    public ResponseEntity<CinemaHallDto> deleteCinemaHallById(@PathVariable String hallId){
        boolean deleted = cinemaHallService.deleteCinemaHall(hallId);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{hallId}")
    public ResponseEntity<CinemaHallDto> updateSpecificFieldOfCinemaHall(
            @PathVariable String hallId,
            @RequestBody Map<String, Object> fields) {
        CinemaHallDto updatedCinemaHall = cinemaHallService.updateSpecificFieldOfCinemaHall(hallId, fields);
        return ResponseEntity.ok(updatedCinemaHall);
    }

    @GetMapping("/byname/{hallName}")
    public ResponseEntity<List<CinemaHallDto>> getCinemaHallsByName(@PathVariable String hallName) {
        List<CinemaHallDto> cinemaHallList = cinemaHallService.getCinemaHallsByName(hallName);
        return ResponseEntity.ok(cinemaHallList);
    }

    @GetMapping("/bylocation/{location}")
    public ResponseEntity<List<CinemaHallDto>> getCinemaHallsByLocation(@PathVariable String location) {
        List<CinemaHallDto> cinemaHallList = cinemaHallService.getCinemaHallsByLocation(location);
        return ResponseEntity.ok(cinemaHallList);
    }

    @GetMapping("/checkSeatAvailability/{hallId}")
    public ResponseEntity<Integer> checkSeatAvailability(@PathVariable String hallId) {
        Integer seatingCapacity = cinemaHallService.checkSeatAvailability(hallId);

        if (seatingCapacity != null && seatingCapacity != -1) {
            return ResponseEntity.ok(seatingCapacity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
