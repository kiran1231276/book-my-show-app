package brainworks.student.repository;

import brainworks.student.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movie,String> {
    List<Movie> findByNameContaining(String contains);
    List<Movie> findByCategoryContaining(String contains);

}
