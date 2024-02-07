package brainworks.student.payload;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowtimeDto {
    @NotEmpty
    @NotNull
    private String  showtimeId;

    @NotEmpty
    @NotNull
    private String movieId;

    @NotEmpty
    @NotNull
    private String cinemaHallId;

    @NotEmpty
    @NotNull
    private String startTime;

    @NotEmpty
    @NotNull
    private String endTime;

    @NotNull
    private Integer availableSeats;

//    @NotEmpty
//    @NotNull
//    private List<MovieDto> movieDto;
//
//    @NotEmpty
//    @NotNull
//    private List<CinemaHallDto> cinemaHallDto;
}
