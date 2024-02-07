package brainworks.student.repository;

import brainworks.student.entity.Booking;
import brainworks.student.payload.response.AdminResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,String> {
    List<Booking> findByUserId(String userId);
    List<Booking> findByMovieId(String movieId);

}
