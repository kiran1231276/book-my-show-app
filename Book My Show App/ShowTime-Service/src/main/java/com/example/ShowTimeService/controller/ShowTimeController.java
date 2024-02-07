package com.example.ShowTimeService.controller;

import com.example.ShowTimeService.dto.ShowTimeDto;
import com.example.ShowTimeService.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/showtimes")
public class ShowTimeController {

    @Autowired
    private ShowTimeService showTimeService;

    @PostMapping("/")
    public ResponseEntity<ShowTimeDto> createShowTime(@RequestBody ShowTimeDto showTimeDto) {
        ShowTimeDto createdShowTime = showTimeService.createShowTime(showTimeDto);
        return new ResponseEntity<>(createdShowTime, HttpStatus.CREATED);
    }

    @GetMapping("/{showTimeId}")
    public ResponseEntity<ShowTimeDto> getCinemaHallById(@PathVariable String showTimeId){
        ShowTimeDto showTimeById = showTimeService.getShowTimeById(showTimeId);
        return ResponseEntity.ok(showTimeById);
    }

    @PutMapping("/{showTimeId}")
    public ResponseEntity<ShowTimeDto> updateShowTime(
            @PathVariable String showTimeId,
            @RequestBody ShowTimeDto showTimeDto) {
        ShowTimeDto updatedShowTime = showTimeService.updateShowTime(showTimeId, showTimeDto);
        return new ResponseEntity<>(updatedShowTime, HttpStatus.OK);
    }

    @PatchMapping("/{showTimeId}")
    public ResponseEntity<ShowTimeDto> updateSpecificFieldOfShowTime(
            @PathVariable String showTimeId,
            @RequestBody Map<String, Object> fields) {
        ShowTimeDto updatedShowTime = showTimeService.updateSpecificFieldOfShowTime(showTimeId, fields);
        return new ResponseEntity<>(updatedShowTime, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity <List<ShowTimeDto>> getAllShowTime(){
        List<ShowTimeDto> allShowTime = showTimeService.getAllShowTime();
        return new ResponseEntity<>(allShowTime,HttpStatus.OK);
    }

    @GetMapping("/availableSeats/{showTimeId}")
    public ResponseEntity<ShowTimeDto> getAvailableSeats(@PathVariable String showTimeId) {
        ShowTimeDto showTimeDto = showTimeService.getAvailableSeats(showTimeId);
        return new ResponseEntity<>(showTimeDto, HttpStatus.OK);
    }

}
