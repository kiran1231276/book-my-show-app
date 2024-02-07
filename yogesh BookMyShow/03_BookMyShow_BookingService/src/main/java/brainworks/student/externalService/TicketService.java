package brainworks.student.externalService;

import brainworks.student.payload.request.SearchRequest;
import brainworks.student.payload.request.TicketRequest;
import brainworks.student.payload.response.SearchResponse;
import brainworks.student.payload.response.TicketResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("TICKET-SERVICE")
public interface TicketService {
    @PostMapping("/api/v1/tickets/checkBookedTickets")
    List<SearchResponse> checkTickets(@RequestBody SearchRequest searchRequest);
    @PostMapping("/api/v1/tickets/bookTicket")
    TicketResponse BookTicket(TicketRequest ticketRequest);
    @GetMapping("/api/v1/tickets/getAllTicketsbyUserId/{userId}")
    List<TicketResponse> getAllTicketByUserId(String userId);

    @PutMapping("/api/v1/tickets/mapBooking/{ticketId}")
    TicketResponse mapBooking(@PathVariable String ticketId,@RequestBody TicketRequest ticketRequest);

    @GetMapping("api/v1/tickets/getAllTicketByBookingId/{bookingId}")
    List<TicketResponse> getAllTicketByBookingId (@PathVariable String bookingId);



}
