package brainworks.student.service;

import brainworks.student.payload.request.BookingDto;
import brainworks.student.payload.request.BookingRequest;
import brainworks.student.payload.response.AdminResponse;
import brainworks.student.payload.response.UserResponseDto;

import java.util.List;

public interface BookingService {
    UserResponseDto createBooking (BookingRequest bookingRequest);
    List <BookingDto> findAllBooking();
    List<AdminResponse> findBookingsByUser(String userId);
    List<BookingDto> findBookingsByMovie(String movieId);

    Boolean cancelBooking(String bookingId);

    String confirmBooking(String bookingId);

    Boolean statusbooking(String bookingId);
}