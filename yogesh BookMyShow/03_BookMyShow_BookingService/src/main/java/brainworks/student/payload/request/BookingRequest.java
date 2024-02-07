package brainworks.student.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private String bookingId;
    private String foodItemName;
    private Integer foodItemQty;
    private Double foodItemPrice;
    private String userId;
    private String movieId;
    private String cinemaHallId;
    private String showtimeId;
    private LocalDate movieDate;
    private String ticketCategory;
    private List<String> totalSeats;
    private String movieTime;
    //private String paymentId;
    private Double totalAmount;
}
