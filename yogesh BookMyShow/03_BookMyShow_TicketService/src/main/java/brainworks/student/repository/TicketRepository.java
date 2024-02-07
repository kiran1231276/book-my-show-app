package brainworks.student.repository;

import brainworks.student.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,String> {
    List<Ticket> findByUserId(String userId);

    List<Ticket> findByBookingId(String bookingId);


}
