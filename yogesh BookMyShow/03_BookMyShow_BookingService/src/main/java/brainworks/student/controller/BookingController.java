package brainworks.student.controller;

import brainworks.student.payload.request.BookingDto;
import brainworks.student.payload.request.BookingRequest;
import brainworks.student.payload.response.AdminResponse;
import brainworks.student.payload.response.UserResponseDto;
import brainworks.student.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @PostMapping("/")
    public ResponseEntity<UserResponseDto> createBooking(@RequestBody BookingRequest bookingRequest){
        UserResponseDto booking = bookingService.createBooking (bookingRequest);
        return new ResponseEntity<> (booking, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookingDto>> getAllBooking(){
        List<BookingDto> bookingDtoList = bookingService.findAllBooking ();
        return new ResponseEntity<> (bookingDtoList, HttpStatus.OK);
    }

    @GetMapping("/getBookingsByMovie/{movieId}")
    public ResponseEntity<List<BookingDto>> getBookingsByMovie(@PathVariable String movieId){
        List<BookingDto> bookingDtoList = bookingService.findBookingsByMovie (movieId);
        return new ResponseEntity<> (bookingDtoList, HttpStatus.OK);
    }

    @GetMapping("/getAdminResponseBooking/{userId}")
    public ResponseEntity<List<AdminResponse>> getAdminResponseBooking(@PathVariable String userId){
        List<AdminResponse> bookingsByUser = bookingService.findBookingsByUser (userId);
        return new ResponseEntity<> (bookingsByUser, HttpStatus.OK);
    }
}

