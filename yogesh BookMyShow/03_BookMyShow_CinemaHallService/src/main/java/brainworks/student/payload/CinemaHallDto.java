package brainworks.student.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaHallDto {
    @NotEmpty
    @NotNull
    private String hallId;

    @NotEmpty
    @NotNull
    @Size(min = 2,message = "Atleast 2 characters expected!!!")
    private String name;

    @NotEmpty
    @NotNull
    private String location;

    @NotNull
    private Integer seatingCapacity;

    @NotEmpty
    @NotNull
    private String seatType;

    @NotNull
    private Integer screens;
}
