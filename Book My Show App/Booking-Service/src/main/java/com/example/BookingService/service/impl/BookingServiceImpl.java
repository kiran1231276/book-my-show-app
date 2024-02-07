package com.example.BookingService.service.impl;

import com.example.BookingService.dto.BookingDto;
import com.example.BookingService.dto.CinemaHallInfoDto;
import com.example.BookingService.dto.ShowTimeInfoDto;
import com.example.BookingService.entity.Booking;
import com.example.BookingService.entity.SeatBooking;
import com.example.BookingService.external.service.CinemaHallServiceClient;
import com.example.BookingService.external.service.ShowTimeServiceClient;
import com.example.BookingService.repository.BookingRepository;
import com.example.BookingService.service.BookingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CinemaHallServiceClient hallServiceClient;

    @Autowired
    private ShowTimeServiceClient showTimeServiceClient;

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {

        // Fetch ShowTimeDto to get startDatetime, endDatetime, and movieId
        ShowTimeInfoDto showTimeDto = showTimeServiceClient.getShowTimeById(bookingDto.getShowTimeId());

        // Fetch CinemaHallDto to get seatType
        CinemaHallInfoDto cinemaHallDto = hallServiceClient.getCinemaHallById(bookingDto.getHallId());

        List<SeatBooking> seatBookings = bookingDto.getSeatBookings();
        int numberOfSeatsBooked = seatBookings.stream().mapToInt(SeatBooking::getNumberOfSeatsBooked).sum();

        int totalAmount = 0;

        for (SeatBooking seatBooking : seatBookings) {
            String seatType = seatBooking.getSeatType();

            // Check if the provided seatType is valid
            if (isValidSeatType(seatType)) {
                int price = getPriceForSeatType(seatType);

                // Calculate the total amount for this seat booking
                int amountForBooking = price * seatBooking.getNumberOfSeatsBooked();
                totalAmount += amountForBooking;

            } else {
                throw new IllegalArgumentException("Invalid seat type: " + seatType);
            }
        }

        // Check maximum seats per user
        if (numberOfSeatsBooked > 4) {
            throw new IllegalArgumentException("Exceeded maximum seats per user you have only booked 4 seats.........");
        }

        // Deduct availableSeats
        showTimeDto.setAvailableSeats(showTimeDto.getAvailableSeats() - numberOfSeatsBooked);

        // Update ShowTimeDto using Feign client
        ShowTimeInfoDto updatedShowTimeDto = showTimeServiceClient.updateShowTime(bookingDto.getShowTimeId(), showTimeDto);

        // Create BookingDto
        BookingDto createdBooking = BookingDto.builder()
                .bookingId(UUID.randomUUID().toString())
                .userId(bookingDto.getUserId())
                .movieId(showTimeDto.getMovieId())
                .hallId(bookingDto.getHallId())
                .showTimeId(bookingDto.getShowTimeId())
                .bookingDateTime(LocalDateTime.now())
                .startDateTime(showTimeDto.getStartDateTime())
                .endDateTime(showTimeDto.getEndDateTime())
                .seatBookings(seatBookings)
                .totalAmount(totalAmount)
                .numberOfSeatsBooked(numberOfSeatsBooked)
                .bookingStatus("PENDING")
                .build();

        // Save the booking in the database
        bookingRepository.save(mapDtoToEntity(createdBooking));

        return createdBooking;
    }

    // check if the seatType is valid
    private boolean isValidSeatType(String seatType) {
        return seatType != null && (seatType.equals("Diamond") || seatType.equals("Gold") || seatType.equals("Platinum"));
    }

    // get the price for a given seatType
    private int getPriceForSeatType(String seatType) {

        return switch (seatType) {
            case "Diamond" -> 250;
            case "Gold" -> 200;
            case "Platinum" -> 150;
            default -> throw new IllegalArgumentException("Invalid seat type: " + seatType);
        };
}

    @Override
    public BookingDto getBookingById(String bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        return optionalBooking.map(this::convertToDto).orElse(null);
    }

    @Override
    public List<BookingDto> getAllBooking() {
        List<Booking> allBookings = bookingRepository.findAll();
        return allBookings.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> getBookingsByUserId(String userId) {
        List<Booking> bookingsByUserId = bookingRepository.findByUserId(userId);
        return bookingsByUserId.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> getBookingsByMovieId(String movieId) {
        List<Booking> bookingsByMovieId = bookingRepository.findByMovieId(movieId);
        return bookingsByMovieId.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> getBookingsByHallId(String hallId) {
        List<Booking> bookingsByHallId = bookingRepository.findByHallId(hallId);
        return bookingsByHallId.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> getBookingsByShowTimeId(String showTimeId) {
        List<Booking> bookingsByShowTimeId = bookingRepository.findByShowTimeId(showTimeId);
        return bookingsByShowTimeId.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // Helper method to convert Booking entity to BookingDto
    private BookingDto convertToDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        BeanUtils.copyProperties(booking, bookingDto);
        return bookingDto;
    }

    // Helper method to map BookingDto to Booking entity
    private Booking mapDtoToEntity(BookingDto bookingDto) {
        Booking booking = new Booking();
        BeanUtils.copyProperties(bookingDto, booking);
        return booking;
    }
}
