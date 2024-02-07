package brainworks.student.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaHallDto {
    private String hallId;
    private String name;
    private String location;
    private Integer seatingCapacity;
    private String seatType;
    private Integer screens;
}
