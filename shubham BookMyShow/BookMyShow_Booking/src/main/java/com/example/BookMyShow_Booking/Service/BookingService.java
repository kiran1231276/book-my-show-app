package com.example.BookMyShow_Booking.Service;

import com.example.BookMyShow_Booking.Dto.BookingDto;

import java.util.List;

public interface BookingService {


    public BookingDto createBooking(BookingDto bookingDto);
    public List<BookingDto> getAll();

    public BookingDto getById(String bookingDto);

}
