package brainworks.student.payload.response;

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
    private String name;
    private LocalDate releaseDate;
    private String category;
    private List<String> genre;
    private String ratings;
    private String country;
    private String poster;
}
