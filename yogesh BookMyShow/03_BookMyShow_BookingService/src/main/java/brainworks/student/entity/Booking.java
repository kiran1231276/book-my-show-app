package brainworks.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    private String bookingId;
    private String userId;
    private String movieId;
    private String cinemaHallId;
    private String showtimeId;
    private List<String> seats;
    private Double totalAmount;
    private String status;
    private String movieTime;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createDate;
    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDate updateDate;


}
