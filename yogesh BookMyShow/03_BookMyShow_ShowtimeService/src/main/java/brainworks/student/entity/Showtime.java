package brainworks.student.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Showtime {
    @Id
    private String  showtimeId;
    private String movieId;
    private String cinemaHallId;
    private String startTime;
    private String endTime;
    private Integer availableSeats;
//    @Transient
//    private List<MovieDto> movieDto;
//    @Transient
//    private List<CinemaHallDto> cinemaHallDto;

}
