//package brainworks.student.externalService;
//
//import brainworks.student.payload.response.BookingDto;
//import brainworks.student.payload.response.UserResponseDto;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.List;
//
//@FeignClient("BOOKING-SERVICE")
//public interface BookingService {
//    @GetMapping("/api/v1/bookings/")
//    List<BookingDto> getAllbookings();
//
//    @GetMapping("/api/v1/bookings/getBookingsByUser/{userId}")
//    BookingDto getBookingsByUser(@PathVariable String userId);
//
//
//    @PostMapping("/api/v1/bookings/")
//    BookingDto createBookings();
//}
