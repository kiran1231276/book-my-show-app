package brainworks.student.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {

    private String ticketId;
    private String movieId;
    private String hallId;
    private String showtimeId;
    private LocalDate movieDate;
    private String bookingStatus;
    private String seatNo;
    private String ticketCategory;
}
