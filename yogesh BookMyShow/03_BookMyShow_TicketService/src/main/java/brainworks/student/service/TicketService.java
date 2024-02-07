package brainworks.student.service;

import brainworks.student.payload.request.SearchRequest;
import brainworks.student.payload.request.TicketRequest;
import brainworks.student.payload.response.SearchResponse;
import brainworks.student.payload.response.TicketResponse;
import java.util.List;

public interface TicketService {

    TicketResponse createTicket(TicketRequest ticketRequest);
    TicketResponse mapBooking(String ticketId,TicketRequest ticketRequest);
    List<TicketResponse> getAllTicket();
    List<TicketResponse> getAllTicketByUserId(String bookingId);
    TicketResponse getTicketById(String ticketId);
    List<SearchResponse> checkBookedTickets(SearchRequest searchRequest);
    List<TicketResponse> getAllTicketByBookingId(String bookingId);


}

