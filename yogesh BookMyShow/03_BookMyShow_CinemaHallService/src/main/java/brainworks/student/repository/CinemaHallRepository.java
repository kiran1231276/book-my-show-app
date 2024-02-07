package brainworks.student.repository;

import brainworks.student.entity.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, String> {
    List<CinemaHall> findByName(String name);


}
