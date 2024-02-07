package com.example.BookMyShow_Booking.Conroller;


import com.example.BookMyShow_Booking.ApiConstant.Constants;
import com.example.BookMyShow_Booking.Dto.BookingDto;
import com.example.BookMyShow_Booking.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/booking")
public class BookingController {


    @Autowired
    BookingService bookingService;

    @PostMapping("/")
    public ResponseEntity<Constants> creeateBooking(@RequestBody BookingDto bookingDto) {
        Constants constants = new Constants();

        BookingDto booking = bookingService.createBooking(bookingDto);
        constants.setBookingId(booking.getBookingId());
        constants.setUserID(booking.getUserId());
        constants.setName(booking.getUser().getName());
        constants.setUserName(booking.getUser().getUserName());
        constants.setEmail(booking.getUser().getEmail());

        constants.setTotalAmount(booking.getTotalAmount());
        constants.setStatus(booking.getStatus());
        constants.setSeats(booking.getSeats());

        constants.setMovieId(booking.getMovieId());
        constants.setMovieName(booking.getMovies().getName());
        constants.setCategory(booking.getMovies().getCategory());
        constants.setGenre(booking.getMovies().getGenre());
        constants.setRating(booking.getMovies().getRating());
        constants.setLanguage(booking.getMovies().getLanguage());
        constants.setPoster(booking.getMovies().getPoster());

        constants.setShowtimeID(bookingDto.getShowTimeId());
        constants.setTheaterId(booking.getTheaterId());
        constants.setTheatername(booking.getTheaters().getName());
        constants.setLocation(booking.getTheaters().getLocation());
        constants.setScreens(booking.getTheaters().getScreens());
        constants.setFoodName(booking.getFoodName());

        constants.setPaymentID(booking.getPaymentID());
        constants.setPaymentStatus("Conformed");
        constants.setTotaPayedAmountt(booking.getTotalAmount());
        constants.setCardNumber(booking.getCardNumber());
        constants.setCardHolderName(booking.getCardHolderName());
        constants.setCardExpire(booking.getCardExpire());
        constants.setCardCvv(booking.getCardCvv());
        constants.setTimestamp(booking.getTimestamp());


        return new ResponseEntity<>(constants, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<Constants>> getAllmovies() {

        List<BookingDto> bookingDto = bookingService.getAll();

        List<Constants> constantss = new ArrayList<>();

        bookingDto.stream().map((booking) -> {


            Constants constants = new Constants();
            constants.setBookingId(booking.getBookingId());
            constants.setUserID(booking.getUserId());
            constants.setName(booking.getUser().getName());
            constants.setUserName(booking.getUser().getUserName());
            constants.setEmail(booking.getUser().getEmail());

            constants.setTotalAmount(booking.getTotalAmount());
            constants.setStatus(booking.getStatus());
            constants.setSeats(booking.getSeats());

            constants.setMovieId(booking.getMovieId());
            constants.setMovieName(booking.getMovies().getName());
            constants.setCategory(booking.getMovies().getCategory());
            constants.setGenre(booking.getMovies().getGenre());
            constants.setRating(booking.getMovies().getRating());
            constants.setLanguage(booking.getMovies().getLanguage());
            constants.setPoster(booking.getMovies().getPoster());

            constants.setShowtimeID(booking.getShowTimeId());
            constants.setTheaterId(booking.getTheaterId());
            constants.setTheatername(booking.getTheaters().getName());
            constants.setLocation(booking.getTheaters().getLocation());
            constants.setScreens(booking.getTheaters().getScreens());

            constants.setFoodName(booking.getFoodName());


            constants.setPaymentID(booking.getPaymentID());
            constants.setPaymentStatus("Conformed");
            constants.setTotaPayedAmountt(booking.getTotalAmount());
            constants.setTimestamp(booking.getTimestamp());

            constantss.add(constants);
            return booking;

        }).collect(Collectors.toList());


        return new ResponseEntity<>(constantss, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Constants> getBookingByID(@PathVariable String id) {

        BookingDto booking = bookingService.getById(id);

        Constants constants = new Constants();
        constants.setBookingId(booking.getBookingId());
        constants.setUserID(booking.getUserId());
        constants.setName(booking.getUser().getName());
        constants.setUserName(booking.getUser().getUserName());
        constants.setEmail(booking.getUser().getEmail());

        constants.setTotalAmount(booking.getTotalAmount());
        constants.setStatus(booking.getStatus());
        constants.setSeats(booking.getSeats());

        constants.setMovieId(booking.getMovieId());
        constants.setMovieName(booking.getMovies().getName());
        constants.setCategory(booking.getMovies().getCategory());
        constants.setGenre(booking.getMovies().getGenre());
        constants.setRating(booking.getMovies().getRating());
        constants.setLanguage(booking.getMovies().getLanguage());
        constants.setPoster(booking.getMovies().getPoster());

        constants.setShowtimeID(booking.getShowTimeId());
        constants.setTheaterId(booking.getTheaterId());
        constants.setTheatername(booking.getTheaters().getName());
        constants.setLocation(booking.getTheaters().getLocation());
        constants.setScreens(booking.getTheaters().getScreens());
        constants.setFoodName(booking.getFoodName());


        constants.setPaymentID(booking.getPaymentID());
        constants.setPaymentStatus("Conformed");
        constants.setTotaPayedAmountt(booking.getTotalAmount());
        constants.setTimestamp(booking.getTimestamp());

        return new ResponseEntity<>(constants, HttpStatus.CREATED);
    }

}
