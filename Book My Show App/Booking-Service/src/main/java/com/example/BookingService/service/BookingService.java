package com.example.BookingService.service;

import com.example.BookingService.dto.BookingDto;

import java.util.List;

public interface BookingService {

    BookingDto createBooking(BookingDto bookingDto);

    BookingDto getBookingById(String bookingId);
    List<BookingDto> getAllBooking();

    List<BookingDto> getBookingsByUserId(String userId);

    List<BookingDto> getBookingsByMovieId(String movieId);

    List<BookingDto> getBookingsByHallId(String hallId);

    List<BookingDto> getBookingsByShowTimeId(String showTimeId);
}
