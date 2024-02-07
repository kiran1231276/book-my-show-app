package brainworks.student.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {

    private String ticketId;
    private String bookingId;
    private String userId;
    private String movieId;
    private String hallId;
    private String showtimeId;
    private LocalDate movieDate;
    private String seatNo;
    private String ticketCategory;
}
