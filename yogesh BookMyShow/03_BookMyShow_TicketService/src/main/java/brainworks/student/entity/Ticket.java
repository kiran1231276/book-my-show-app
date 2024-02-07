package brainworks.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
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
