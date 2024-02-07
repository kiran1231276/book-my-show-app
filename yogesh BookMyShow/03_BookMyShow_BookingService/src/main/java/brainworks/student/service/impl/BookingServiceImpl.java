package brainworks.student.service.impl;

import brainworks.student.entity.Booking;
import brainworks.student.exception.ResourceNotFoundException;
import brainworks.student.externalService.*;
import brainworks.student.payload.request.BookingDto;
import brainworks.student.payload.request.BookingRequest;
import brainworks.student.payload.request.FoodRequest;
import brainworks.student.payload.request.TicketRequest;
import brainworks.student.payload.response.*;
import brainworks.student.repository.BookingRepository;
import brainworks.student.service.BookingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    UserService userService;
    @Autowired
    MovieService movieService;
    @Autowired
    CinemaHallService cinemaHallService;
    @Autowired
    ShowtimeService showtimeService;
    @Autowired
    FoodService foodService;
    @Autowired
    TicketService ticketService;
    @Autowired
    PaymentService paymentService;
    @Override
    public UserResponseDto createBooking(BookingRequest bookingRequest) {

        String bookingId = UUID.randomUUID ().toString ();
        bookingRequest.setBookingId (bookingId);

        UserDto userById = userService.getUserById (bookingRequest.getUserId ());
        MovieDto movieById = movieService.getMovieById (bookingRequest.getMovieId ());
        CinemaHallDto cinemaHallById = cinemaHallService.getCinemaHallById (bookingRequest.getCinemaHallId ());
        ShowtimeDto showtimeById = showtimeService.getShowtimeById (bookingRequest.getShowtimeId ());

        bookingRequest.setUserId (userById.getUserId ());
        bookingRequest.setMovieId (movieById.getMovieId ());
        bookingRequest.setCinemaHallId (cinemaHallById.getHallId ());




        FoodRequest foodRequest=new FoodRequest ();
        foodRequest.setBookingId (bookingRequest.getBookingId ());
        foodRequest.setFoodId ("");
        foodRequest.setItemName (bookingRequest.getFoodItemName ());
        foodRequest.setUserId (userById.getUserId ());
        foodRequest.setItemQty (bookingRequest.getFoodItemQty ());
        foodRequest.setItemPrice (bookingRequest.getFoodItemPrice ());
        foodRequest.setTotalAmount (0.00);
        FoodResponse foodResponse = foodService.orderFood (foodRequest);

        UserResponseDto userResponseDto = getUserResponseDto (movieById, userById, cinemaHallById, showtimeById,foodResponse);

        List<String> totalSeats = bookingRequest.getTotalSeats ();
        for(String ticketId:totalSeats){
            TicketRequest ticketRequest=new TicketRequest ();
            ticketRequest.setBookingId (bookingId);
            ticketRequest.setUserId (userById.getUserId ());
            ticketService.mapBooking (ticketId,ticketRequest);

        }

        List<TicketResponse> allTicketByBookingId = ticketService.getAllTicketByBookingId (bookingId);

        userResponseDto.setTicketResponseList (allTicketByBookingId);
        List<String> listOfSeats=new ArrayList<> ();
        for (TicketResponse ticketResponse : allTicketByBookingId){
            System.out.println (ticketResponse.getBookingStatus ());
            String seatNo = ticketResponse.getSeatNo ();
            userResponseDto.setTicketdate (ticketResponse.getTicketDate ());
            bookingRequest.setMovieTime (showtimeById.getStartTime ());
            //userResponseDto.setMovieTime (ticketResponse.get);
            listOfSeats.add (seatNo);

        }
        userResponseDto.setTotalSeats (listOfSeats);

        userResponseDto.setFoodBill (foodResponse.getTotalAmount ());

        int noOfTickets = listOfSeats.size ();
        int ticketTotal = 500 * noOfTickets;
        double finalAmount = ticketTotal + foodResponse.getTotalAmount ();


        PaymentResponse paymentResponse = getPaymentResponse (bookingRequest);



        userResponseDto.setPaymentId (paymentResponse.getPaymentId ());
        userResponseDto.setBookingId (paymentResponse.getBookingId ());

        userResponseDto.setTotalBill (finalAmount);




        Booking booking=new Booking ();
        BeanUtils.copyProperties (bookingRequest,booking);
        booking.setTotalAmount (finalAmount);
        booking.setSeats (listOfSeats);
        bookingRepository.save (booking);
        return userResponseDto;
    }

    private static UserResponseDto getUserResponseDto(MovieDto movieById, UserDto userById, CinemaHallDto cinemaHallById, ShowtimeDto showtimeById,FoodResponse foodResponse) {
        UserResponseDto userResponseDto=new UserResponseDto ();
        //userResponseDto.setMovieDto (movieById);
        //userResponseDto.setCinemaHallDto (cinemaHallById);
        //userResponseDto.setShowtimeDto (showtimeById);
        userResponseDto.setEmail (userById.getEmail ());
        userResponseDto.setFullname (userById.getFullname ());
        userResponseDto.setCinemaHallName (cinemaHallById.getName ());
        userResponseDto.setMovieTime (showtimeById.getStartTime ());
        userResponseDto.setMoviePoster (movieById.getPoster ());
        userResponseDto.setLocation (cinemaHallById.getLocation ());
        userResponseDto.setUserId (userById.getUserId ());
        userResponseDto.setMovieName (movieById.getName ());
        userResponseDto.setFood (foodResponse.getItemName ());
        return userResponseDto;
    }

    private PaymentResponse getPaymentResponse(BookingRequest bookingRequest) {
        PaymentDto paymentDto=new PaymentDto ();
        paymentDto.setUserId (bookingRequest.getUserId ());
        paymentDto.setBookingId (bookingRequest.getBookingId ());
        paymentDto.setAmount (bookingRequest.getTotalAmount ());
        paymentDto.setPaymentStatus ("Confirmed");
        paymentDto.setCreateDate (null);
        paymentDto.setPaymentId (null);
        PaymentResponse paymentResponse = paymentService.processPayment (paymentDto);
        return paymentResponse;
    }

    @Override
    public List<BookingDto> findAllBooking() {
        List<Booking> bookingList = bookingRepository.findAll ();
        List<BookingDto> bookingDtos=new ArrayList<> ();
        for(Booking booking:bookingList){
            BookingDto bookingDto=new BookingDto ();
            BeanUtils.copyProperties (booking,bookingDto);
            bookingDtos.add (bookingDto);
        }
        return bookingDtos;
    }

    @Override
    public List<BookingDto> findBookingsByMovie(String movieId) {
        List<Booking> bookingList = bookingRepository.findByMovieId (movieId);
        List<BookingDto> bookingDtos=new ArrayList<> ();
        for(Booking booking:bookingList){
            BookingDto bookingDto=new BookingDto ();
            BeanUtils.copyProperties (booking,bookingDto);
            bookingDtos.add (bookingDto);
        }
        return bookingDtos;
    }

    @Override
    public Boolean cancelBooking(String bookingId) {
        Booking booking = bookingRepository.findById (bookingId)
                .orElseThrow (() -> new ResourceNotFoundException ("Booking", "boookingId", bookingId));
        bookingRepository.delete (booking);
        return booking!=null;
    }

    @Override
    public List<AdminResponse> findBookingsByUser(String userId) {
        List<AdminResponse>adminResponseList=new ArrayList<> ();
        List<Booking> bookings = bookingRepository.findByUserId (userId);
        UserDto userDto = userService.getUserById (userId);
        for(Booking booking:bookings){
            AdminResponse adminResponse=new AdminResponse ();
            MovieDto movieById = movieService.getMovieById (booking.getMovieId ());
            CinemaHallDto cinemaHallById = cinemaHallService.getCinemaHallById (booking.getCinemaHallId ());
            ShowtimeDto showtimeById = showtimeService.getShowtimeById (booking.getShowtimeId ());
            adminResponse.setUserId (userDto.getUserId ());
            adminResponse.setEmail (userDto.getEmail ());
            adminResponse.setFullname (userDto.getFullname ());
            adminResponse.setMovieDto (movieById);
            adminResponse.setShowtimeDto (showtimeById);
            adminResponse.setCinemaHallDto (cinemaHallById);
            adminResponseList.add (adminResponse);
        }
        return adminResponseList;
    }

    @Override
    public String confirmBooking(String bookingId) {
        return null;
    }

    @Override
    public Boolean statusbooking(String bookingId) {
        return null;
    }
}
