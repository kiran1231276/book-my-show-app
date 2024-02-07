package com.example.TicketService.controller;

import com.example.TicketService.dto.TicketDto;
import com.example.TicketService.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/")
    public ResponseEntity<TicketDto> createTicket(@Valid @RequestBody TicketDto ticketDto){
        TicketDto createdTicket = ticketService.createTicket(ticketDto);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable String ticketId){
        TicketDto ticketById = ticketService.getTicketById(ticketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<TicketDto>> getAllTickets(){
        List<TicketDto> allTickets = ticketService.getAllTickets();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<TicketDto>> getTicketByBookingId(@PathVariable String bookingId){
        List<TicketDto> ticketByBookingId = ticketService.getTicketByBookingId(bookingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TicketDto>> getTicketByUserId(@PathVariable String userId){
        List<TicketDto> ticketByUserId = ticketService.getTicketByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<TicketDto>> getTicketByMovieId(@PathVariable String movieId){
        List<TicketDto> ticketByMovieId = ticketService.getTicketByMovieId(movieId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hall/{hallId}")
    public ResponseEntity<List<TicketDto>> getTicketByHallId(@PathVariable String hallId){
        List<TicketDto> ticketByHallId = ticketService.getTicketByHallId(hallId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/showtime/{showTimeId}")
    public ResponseEntity<List<TicketDto>> getTicketByShowTimeId(@PathVariable String showTimeId){
        List<TicketDto> ticketByShowTimeId = ticketService.getTicketByShowTimeId(showTimeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
