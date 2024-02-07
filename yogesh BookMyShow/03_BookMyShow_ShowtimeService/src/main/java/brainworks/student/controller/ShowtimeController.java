package brainworks.student.controller;

import brainworks.student.payload.ShowtimeDto;
import brainworks.student.service.ShowtimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/showtimes")
public class ShowtimeController {
    @Autowired
    ShowtimeService showtimeService;
    @PostMapping("/")
    public ResponseEntity<ShowtimeDto> createShowtime(@Valid @RequestBody ShowtimeDto showtimeDto){
        ShowtimeDto showTime = showtimeService.createShowTime (showtimeDto);
        return new ResponseEntity<> (showTime, HttpStatus.CREATED);
    }
    @GetMapping("/getShowtime/{showtimeId}")
    public ResponseEntity<ShowtimeDto> findShowtimeById(@PathVariable String showtimeId){
        ShowtimeDto showTime = showtimeService.findShowtimeById (showtimeId);
        return new ResponseEntity<> (showTime, HttpStatus.OK);
    }
}
