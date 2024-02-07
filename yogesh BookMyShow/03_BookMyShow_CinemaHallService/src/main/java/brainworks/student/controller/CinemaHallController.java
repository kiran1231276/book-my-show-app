package brainworks.student.controller;

import brainworks.student.payload.CinemaHallDto;
import brainworks.student.service.CinemaHallService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/cinema_hall")
public class CinemaHallController {
    @Autowired
    CinemaHallService cinemaHallService;
    @GetMapping("/")
    public ResponseEntity<List<CinemaHallDto>> getAllCinemaHall(){
        List<CinemaHallDto> allCinemaHall = cinemaHallService.getAllCinemaHall ();
        return new ResponseEntity<> (allCinemaHall, HttpStatus.OK);
    }

    @GetMapping("/getCinemaHall/{cinemaHallId}")
    public ResponseEntity<CinemaHallDto> getCinemaHallById(@PathVariable String cinemaHallId ){
        CinemaHallDto cinemaHall = cinemaHallService.getCinemaHallById (cinemaHallId);
        return new ResponseEntity<> (cinemaHall, HttpStatus.OK);
    }

    @GetMapping("/{CinemaHallName}")
    public ResponseEntity<List<CinemaHallDto>> getAllCinemaHall(@PathVariable String CinemaHallName){
        List<CinemaHallDto> allCinemaHall = cinemaHallService.getCinemaHallByName (CinemaHallName);
        return new ResponseEntity<> (allCinemaHall, HttpStatus.OK);
    }

    @DeleteMapping("/{cinemaHallId}")
    public ResponseEntity<String> deleteCinemaHall(@PathVariable String cinemaHallId ){
        Boolean deleteCinemaHall = cinemaHallService.deleteCinemaHall (cinemaHallId);
        if (deleteCinemaHall) return new ResponseEntity<> ("Cinema hall deleted !!!", HttpStatus.OK);
        else return new ResponseEntity<> ("Request failed !!!", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<CinemaHallDto> createCinemaHall(@Valid @RequestBody CinemaHallDto cinemaHallDto){
        CinemaHallDto cinemaHall = cinemaHallService.createCinemaHall (cinemaHallDto);
        return new ResponseEntity<> (cinemaHall, HttpStatus.CREATED);
    }

    @PutMapping("/{hallId}")
    public ResponseEntity<CinemaHallDto> updateCinemaHallById(
            @PathVariable String hallId,
            @Valid @RequestBody CinemaHallDto cinemaHallDto
    ) {
        cinemaHallService.updateSpecificField(hallId, (Map<String, Object>) cinemaHallDto);

        //  updateSpecificField method returns the updated cinema hall
        CinemaHallDto updatedCinemaHall = cinemaHallService.getCinemaHallById(hallId);

        return ResponseEntity.ok(updatedCinemaHall);
    }





}

