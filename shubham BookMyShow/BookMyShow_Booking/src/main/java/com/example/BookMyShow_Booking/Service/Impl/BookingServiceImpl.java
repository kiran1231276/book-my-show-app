package com.example.BookMyShow_Booking.Service.Impl;

import com.example.BookMyShow_Booking.Dto.*;
import com.example.BookMyShow_Booking.Entity.BookSeats;
import com.example.BookMyShow_Booking.Entity.Booking;
import com.example.BookMyShow_Booking.Exception.ResourceNotFoundException;
import com.example.BookMyShow_Booking.Exception.SeatExtendLimt;
import com.example.BookMyShow_Booking.ExternalService.*;
import com.example.BookMyShow_Booking.Repository.BookingRepository;
import com.example.BookMyShow_Booking.Repository.SeatskRepository;
import com.example.BookMyShow_Booking.Service.BookingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {


    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    MoviesService moviesService;
    @Autowired
    ShowTimeService showTimeService;
    @Autowired
    TheaterService theaterService;
    @Autowired
    UserService userService;

    @Autowired
    PaymentService paymentService;
    @Autowired
    FoodService foodService;

    @Autowired
    SeatskRepository seatskRepository;

    @Autowired
    BookseatServiceExternal bookseatServiceExternal;

    private ObjectMapper objectMapper = new ObjectMapper();

    private String convertObjectToJsonString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            // Handle exception
            e.printStackTrace();
            return null;
        }

    }


    // Convert list of JSON strings to a list of objects
    public <T> List<T> convertJsonStringListToObjectList(List<String> jsonStrings, Class<T> valueType) throws IOException {
        List<T> resultList = new ArrayList<>();

        for (String jsonString : jsonStrings) {
            try {
                T object = objectMapper.readValue(jsonString, valueType);
                resultList.add(object);
            } catch (JsonProcessingException e) {
                e.printStackTrace();

            }
        }
        return resultList;
    }



    @Override
    public BookingDto createBooking(BookingDto bookingDto) {

        String id = UUID.randomUUID().toString();
        bookingDto.setBookingId(id);
        Movies moviess = moviesService.getMovie(bookingDto.getMovieId());
        if (moviess.getMovieId().equals(bookingDto.getMovieId())) {
            bookingDto.setMoviess(convertObjectToJsonString(moviess));
            bookingDto.setMovies(moviess);

        } else {
            throw new ResourceNotFoundException("movie", "id", bookingDto.getMovieId());
        }
        String userName = bookingDto.getUser() != null ? bookingDto.getUser().getUserName() : null;

        User userr = userService.getuser(bookingDto.getUserId());
        if (userr.getUserID().equals(bookingDto.getUserId())) {
            bookingDto.setUserss(convertObjectToJsonString(userr));
            bookingDto.setUser(userr);
        } else {
            throw new ResourceNotFoundException("user", "id", bookingDto.getUserId());
        }

        Theaters theaters = theaterService.getThaera(bookingDto.getTheaterId());
        if (theaters.getTheaterId().equals(bookingDto.getTheaterId())) {
            bookingDto.setTheater(convertObjectToJsonString(theaters));
            bookingDto.setTheaters(theaters);
        } else {
            throw new ResourceNotFoundException("theater", "id", bookingDto.getTheaterId());
        }

        List<ShowTime> showTime1 = showTimeService.getShowTime(bookingDto.getShowTimeId());

        if (showTime1.isEmpty()) {
            throw new ResourceNotFoundException("ShowTime#######", "id", bookingDto.getTheaterId());
        }

        List<Movies> confMovie = new ArrayList<>();
        List<Theaters> theatersList1 = new ArrayList<>();
        List<ShowTime> showTimeDtos = new ArrayList<>();

        List<ShowTime> movieLisrt = showTime1.stream().map((x) -> {
            List<String> movieIdList = x.getMovieIdList();

            List<Movies> moviesLists = movieIdList.stream().map((mov) -> {
                Movies movies = moviesService.getMovie(mov);

                if (movies.getMovieId().equals(bookingDto.getMovieId())) {
                    confMovie.add(movies);
                    return movies;
                }
                return null;
            }).collect(Collectors.toList());


            List<Theaters> theatersList = x.getThetarIdList().stream().map((the) -> {
                Theaters theaterss = theaterService.getThaera(the);

                if (theaterss.getTheaterId().equals(bookingDto.getTheaterId())) {
                    theatersList1.add(theaterss);
                    return theaterss;
                } else {
                    return null;
                }

            }).collect(Collectors.toList());

            if (confMovie.isEmpty() || theatersList1.isEmpty()) {
                throw new ResourceNotFoundException("showTime### ", "id", bookingDto.getShowTimeId());
            }
            return x;

        }).collect(Collectors.toList());

        if(bookingDto.getSeats().size() > 5){
            throw new SeatExtendLimt();
        }

        BookSeats seatLock = new BookSeats();
        seatLock.setMovieId(bookingDto.getMovieId());
        seatLock.setTheaterId(bookingDto.getTheaterId());
        seatLock.setShowTimeId(bookingDto.getShowTimeId());
        seatLock.setSeat(bookingDto.getSeats());
        seatLock.setBookingId(bookingDto.getBookingId());
        bookseatServiceExternal.createBookingSeat(seatLock);


        Double temp = 0D;

        for (String seat : bookingDto.getSeats()) {
            if (seat.startsWith("p")) {
                temp = temp + 300;
            }
            if (seat.startsWith("e")) {
                temp = temp + 270;
            }
            if (seat.startsWith("n")) {
                temp = temp + 200;
            }
        }


        LocalDateTime lockExpirationTime = LocalDateTime.now();

        FoodDto foodDto= new FoodDto();
        Double foodAmount= foodService.OrderFood(bookingDto.getFoodName()).getBody();

        bookingDto.setTotalAmount(foodAmount+temp);

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setBookingID(id);
        paymentDto.setTotalAmount(foodAmount+temp);
        paymentDto.setUserID(userr.getUserID());
        paymentDto.setCardNumber(bookingDto.getCardNumber());
        paymentDto.setCardHolderName(bookingDto.getCardHolderName());
        paymentDto.setCardExpire(bookingDto.getCardExpire());
        paymentDto.setCardCvv(bookingDto.getCardCvv());
        paymentDto.setTimestamp(lockExpirationTime);

        if( (foodAmount+temp)== bookingDto.getTotalAmount()){
            paymentDto.setPaymentStatus("successfully done");
        }else {
            throw new ResourceNotFoundException();
        }


        PaymentDto paymentDto1 = paymentService.craete(paymentDto);

        bookingDto.setPaymentID(paymentDto1.getPaymentID());
        bookingDto.setPaymentStatus(paymentDto1.getPaymentStatus());
        bookingDto.setTimestamp(lockExpirationTime);


        Booking booking = new Booking();
        bookingDto.setStatus("Conformed");

        BeanUtils.copyProperties(bookingDto, booking);
        bookingRepository.save(booking);

        BookingDto bookingDto1 = new BookingDto();
        BeanUtils.copyProperties(booking, bookingDto1);
        return bookingDto;
    }

    @Override
    public List<BookingDto> getAll() {

        List<Booking> bookings = bookingRepository.findAll();

        List<BookingDto> bookingDtos = new ArrayList<>();
        List<Booking> s = bookings.stream().map(x -> {
            Movies movies = moviesService.getMovie(x.getMovieId());
            User user = userService.getuser(x.getUserId());
            Theaters theaters = theaterService.getThaera(x.getTheaterId());
            BookingDto bookingDto = new BookingDto();

            BeanUtils.copyProperties(x, bookingDto);
            bookingDto.setMovies(movies);
            bookingDto.setUser(user);
            bookingDto.setTheaters(theaters);
            bookingDtos.add(bookingDto);
            return x;
        }).collect(Collectors.toList());

        return bookingDtos;
    }

    @Override
    public BookingDto getById(String bookingDto) {

        Booking booking = bookingRepository.findById(bookingDto)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", bookingDto));


        BookingDto bookingDto1 = new BookingDto();

        Movies movies = moviesService.getMovie(booking.getMovieId());
        User user = userService.getuser(booking.getUserId());
        Theaters theaters = theaterService.getThaera(booking.getTheaterId());


        BeanUtils.copyProperties(booking, bookingDto1);
        bookingDto1.setMovies(movies);
        bookingDto1.setUser(user);
        bookingDto1.setTheaters(theaters);
        bookingDto1.setPaymentID(booking.getPaymentID());


        return bookingDto1;

    }


//
//    @Override
//    public BookingDto createBooking(BookingDto bookingDto) {
//
//
//        String id = UUID.randomUUID().toString();
//        bookingDto.setBookingId(id);
//
//        Movies movies = moviesService.getMovie(bookingDto.getMovieId());
//        if (movies.getMovieId().equals(bookingDto.getMovieId())) {
//            bookingDto.setMovies(movies);
//        } else {
//            throw new ResourceNotFoundException("movie", "id", bookingDto.getMovieId());
//
//        }
//
//
//        User user = userService.getuser(bookingDto.getUserId());
//        if (user.getUserID().equals(bookingDto.getUserId())) {
//            bookingDto.setUser(user);
//        } else {
//            throw new ResourceNotFoundException("user", "id", bookingDto.getUserId());
//
//        }
//
//
//        Theaters theaters = theaterService.getThaera(bookingDto.getTheaterId());
//        if (theaters.getTheaterId().equals(bookingDto.getTheaterId())) {
//            bookingDto.setTheaters(theaters);
//        } else {
//            throw new ResourceNotFoundException("theater", "id", bookingDto.getTheaterId());
//
//        }
//
//
//        List<ShowTime> showTime1 = showTimeService.getShowTime(bookingDto.getShowTimeId());
//
//        System.out.println(showTime1.size());
//
//        if (showTime1.isEmpty()) {
//            throw new ResourceNotFoundException("ShowTime", "id", bookingDto.getTheaterId());
//        }
//
//        showTime1.stream().map((show) -> {
//            try {
//                List<Movies> moviesListe = convertJsonStringListToObjectList(show.getMoviesJson(), Movies.class);
////                moviesListe.stream().map((mov) -> {
////                    if (mov.getMovieId().equals(bookingDto.getMovieId())) {
//////                        List<Theaters> theaters1 = mov.getTheatersList().stream().map((the) -> {
////                            if (the.getTheaterId().equals(theaters.getTheaterId())) {
//                                return the;
//                            }
//                            return null;
//                        }).collect(Collectors.toList());
//
//                        System.out.println(theaters1.size() + "sdffffffffffffffffffff");
//
//                        theaters1.stream().forEach((e) -> System.out.println(e.getTheaterId()));
//
//
//                        if (theaters1.isEmpty()) {
//                            throw new ResourceNotFoundException("Movie", "id", bookingDto.getMovieId());
//                        } else {
//                            return mov;
//
//                        }
//
//                    } else {
//                        throw new ResourceNotFoundException("Movie", "id", bookingDto.getMovieId());
//                    }
//
//                }).collect(Collectors.toList());
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            return show;
//
//        }).collect(Collectors.toList());
//
//
//        Booking booking = new Booking();
//        BeanUtils.copyProperties(bookingDto, booking);
//        bookingRepository.save(booking);
//        BookingDto bookingDto1 = new BookingDto();
//        BeanUtils.copyProperties(booking, bookingDto1);
//        return bookingDto;
//    }


}
