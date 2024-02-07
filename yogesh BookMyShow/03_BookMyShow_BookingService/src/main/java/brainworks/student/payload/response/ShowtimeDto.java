package brainworks.student.payload.response;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
