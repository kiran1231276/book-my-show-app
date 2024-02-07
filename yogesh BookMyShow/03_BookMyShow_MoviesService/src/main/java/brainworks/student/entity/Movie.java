package brainworks.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    private String movieId;
    private String name;
    private LocalDate releaseDate;
    private String category;
    private List<String> genre=new ArrayList<> ();
    private String ratings;
    private String country;
    private String poster;
}
