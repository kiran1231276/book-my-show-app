package brainworks.student.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    private String movieId;
    private String hallId;
    private String showtimeId;
    private LocalDate movieDate;
    private String bookingStatus;
    private String ticketCategory;
}
