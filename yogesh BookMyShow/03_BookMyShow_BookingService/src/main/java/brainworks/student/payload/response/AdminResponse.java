package brainworks.student.payload.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {
    private String userId;
    private String fullname;
    private String email;
    private MovieDto movieDto;
    private CinemaHallDto cinemaHallDto;
    private ShowtimeDto showtimeDto;


}
