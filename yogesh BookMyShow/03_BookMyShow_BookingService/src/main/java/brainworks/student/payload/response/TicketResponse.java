package brainworks.student.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {

    private String ticketId;
    private String bookingId;
    private String userId;
    private String movieId;
    private String hallId;
    private String showtimeId;
    private LocalDate ticketDate;
    private String seatNo;
    private String bookingStatus;
    private String ticketCategory;
}
