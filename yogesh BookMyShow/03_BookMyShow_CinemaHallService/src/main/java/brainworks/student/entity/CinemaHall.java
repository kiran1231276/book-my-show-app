package brainworks.student.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaHall {
    @Id
    private String hallId;
    private String name;
    private String location;
    private Integer seatingCapacity;
    private Integer availableSeats;
    private String seatType;
    private Integer screens;
}
