package brainworks.student.repository;

import brainworks.student.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<Showtime,String> {

}
