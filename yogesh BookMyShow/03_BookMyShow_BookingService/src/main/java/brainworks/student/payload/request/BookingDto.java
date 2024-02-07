package brainworks.student.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private String bookingId;
    private String userId;
    private String movieId;
    private String cinemaHallId;
    private String showtimeId;
    private String totalSeats;
    private Double totalAmount;
    private String status;
    private LocalDate createDate;
    private String movieTime;
}
