package brainworks.student.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private String movieId;
    @NotEmpty
    @Size(min = 2,message = "Atleast 2 characters expected!!!")
    private String name;

    @NotNull
    private LocalDate releaseDate;

    @NotNull
    @NotEmpty
    private String category;

    @NotNull
    @NotEmpty
    private List<String> genre;

    @NotNull
    @NotEmpty
    private String ratings;

    @NotNull
    @NotEmpty
    private String country;

    @NotNull
    @NotEmpty
    private String poster;
}
