package com.example.BookingService.controller;

import com.example.BookingService.dto.BookingDto;
import com.example.BookingService.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/")
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
        BookingDto createdBooking = bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable String bookingId) {
        BookingDto booking = bookingService.getBookingById(bookingId);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        List<BookingDto> allBookings = bookingService.getAllBooking();
        return new ResponseEntity<>(allBookings, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingDto>> getBookingsByUserId(@PathVariable String userId) {
        List<BookingDto> bookingsByUserId = bookingService.getBookingsByUserId(userId);
        return new ResponseEntity<>(bookingsByUserId, HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<BookingDto>> getBookingsByMovieId(@PathVariable String movieId) {
        List<BookingDto> bookingsByMovieId = bookingService.getBookingsByMovieId(movieId);
        return new ResponseEntity<>(bookingsByMovieId, HttpStatus.OK);
    }

    @GetMapping("/hall/{hallId}")
    public ResponseEntity<List<BookingDto>> getBookingsByHallId(@PathVariable String hallId) {
        List<BookingDto> bookingsByHallId = bookingService.getBookingsByHallId(hallId);
        return new ResponseEntity<>(bookingsByHallId, HttpStatus.OK);
    }

    @GetMapping("/showtime/{showTimeId}")
    public ResponseEntity<List<BookingDto>> getBookingsByShowTimeId(@PathVariable String showTimeId) {
        List<BookingDto> bookingsByShowTimeId = bookingService.getBookingsByShowTimeId(showTimeId);
        return new ResponseEntity<>(bookingsByShowTimeId, HttpStatus.OK);
    }
}
