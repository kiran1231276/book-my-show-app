package brainworks.student.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private String bookingId;
    private String paymentId;
    private String userId;
    private String fullname;
    private String email;
    private String movieName;
    private String moviePoster;
    private String movieTime;
    private LocalDate ticketdate;
    //private MovieDto movieDto;
    private String location;
    private String cinemaHallName;
    private List<String> totalSeats;
    //private CinemaHallDto cinemaHallDto;
    //private ShowtimeDto showtimeDto;
    private String food;
    private double foodBill;
    private double totalBill;
    private List<TicketResponse> ticketResponseList;

}
