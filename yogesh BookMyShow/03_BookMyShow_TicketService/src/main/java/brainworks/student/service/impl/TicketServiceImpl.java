package brainworks.student.service.impl;

import brainworks.student.entity.Ticket;
import brainworks.student.exception.ResourceNotFoundException;
import brainworks.student.payload.request.SearchRequest;
import brainworks.student.payload.request.TicketRequest;
import brainworks.student.payload.response.SearchResponse;
import brainworks.student.payload.response.TicketResponse;
import brainworks.student.repository.TicketRepository;
import brainworks.student.service.TicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public TicketResponse createTicket(TicketRequest ticketRequest) {
        ticketRequest.setTicketId (UUID.randomUUID ().toString ());
        TicketResponse ticketResponse = setValues (ticketRequest);
        Ticket ticket=new Ticket ();
        BeanUtils.copyProperties (ticketRequest,ticket);
        ticket.setBookingStatus ("Available");
        Ticket saved = ticketRepository.save (ticket);
        BeanUtils.copyProperties (saved,ticketResponse);
        return ticketResponse;
    }

    @Override
    public TicketResponse mapBooking(String ticketId, TicketRequest ticketRequest) {
        Ticket ticket1 = ticketRepository.findById (ticketId)
                .orElseThrow (() -> new ResourceNotFoundException ("Ticket", "ticketId", ticketId));
        Ticket ticket2=new Ticket ();
        ticket2.setBookingId (ticketRequest.getBookingId ());
        ticket2.setUserId (ticketRequest.getUserId ());
        ticket2.setTicketId (ticket1.getTicketId ());
        ticket2.setTicketCategory (ticket1.getTicketCategory ());
        ticket2.setBookingStatus ("Confirmed");
        ticket2.setSeatNo (ticket1.getSeatNo ());
        ticket2.setShowtimeId (ticket1.getShowtimeId ());
        ticket2.setHallId (ticket1.getHallId ());
        ticket2.setMovieId (ticket1.getMovieId ());
        ticket2.setTicketDate (ticket1.getTicketDate ());
        TicketResponse ticketResponse=new TicketResponse ();
        BeanUtils.copyProperties (ticket2,ticketResponse);
        ticketRepository.save(ticket2);
        return ticketResponse;
    }


    private static TicketResponse setValues(TicketRequest ticketRequest) {
        TicketResponse ticketResponse=new TicketResponse ();
        ticketResponse.setTicketCategory (ticketRequest.getTicketCategory ());
        ticketResponse.setHallId (ticketRequest.getHallId ());
        ticketResponse.setMovieId (ticketRequest.getMovieId ());
        ticketResponse.setBookingId (ticketRequest.getBookingId ());
        ticketResponse.setShowtimeId (ticketRequest.getShowtimeId ());
        ticketResponse.setUserId (ticketRequest.getTicketId ());
        ticketResponse.setSeatNo (ticketRequest.getSeatNo ());
        return ticketResponse;
    }

    @Override
    public List<TicketResponse> getAllTicket() {
        List<Ticket> tickets = ticketRepository.findAll ();
        List<TicketResponse> ticketResponseList=new ArrayList<> ();
       for(Ticket ticket:tickets){
           TicketResponse ticketResponse=new TicketResponse ();
           BeanUtils.copyProperties (ticket,ticketResponse);
           ticketResponseList.add (ticketResponse);
       }
       return ticketResponseList;
    }

    @Override
    public List<TicketResponse> getAllTicketByUserId(String userId) {
        List<Ticket> tickets = ticketRepository.findByUserId (userId);
        List<TicketResponse> ticketResponseList=new ArrayList<> ();
        for(Ticket ticket:tickets){
            TicketResponse ticketResponse=new TicketResponse ();
            BeanUtils.copyProperties (ticket,ticketResponse);
            ticketResponseList.add (ticketResponse);
        }
        return ticketResponseList;
    }

    @Override
    public TicketResponse getTicketById(String ticketId) {
        Ticket ticket = ticketRepository.findById (ticketId)
                .orElseThrow (() -> new ResourceNotFoundException ("Ticket", "TicketId", ticketId));
        TicketResponse ticketResponse=new TicketResponse ();
        BeanUtils.copyProperties (ticket,ticketResponse);
        return ticketResponse;
    }

    @Override
    public List<SearchResponse> checkBookedTickets(SearchRequest searchRequest) {
        ArrayList<SearchResponse> searchResponse = new ArrayList<> ();
        Ticket queryBuilder = new Ticket ();
        Ticket tickets = buildQuery (searchRequest, queryBuilder);
        Example<Ticket> example = Example.of (tickets);
        List<Ticket> ticketList = ticketRepository.findAll (example);
        for (Ticket ticket : ticketList) {
            SearchResponse sr = new SearchResponse ();
            BeanUtils.copyProperties (ticket, sr);
            searchResponse.add (sr);
        }
        return searchResponse;
    }

    @Override
    public List<TicketResponse> getAllTicketByBookingId(String bookingId) {
        List<TicketResponse> ticketResponseList=new ArrayList<> ();
        List<Ticket> byBookingId = ticketRepository.findByBookingId (bookingId);
        for(Ticket ticket:byBookingId){
            TicketResponse ticketResponse=new TicketResponse ();
            BeanUtils.copyProperties (ticket,ticketResponse);
            ticketResponseList.add (ticketResponse);
        }
        return ticketResponseList;
    }

    private static Ticket buildQuery(SearchRequest searchRequest, Ticket queryBuilder) {
        if (searchRequest.getBookingStatus () != null && !searchRequest.equals (""))
            queryBuilder.setBookingStatus (searchRequest.getBookingStatus ());
        if (searchRequest.getMovieId () != null && !searchRequest.equals (""))
            queryBuilder.setMovieId (searchRequest.getMovieId ());
        if (searchRequest.getHallId () != null && !searchRequest.equals (""))
            queryBuilder.setHallId (searchRequest.getHallId ());
        if (searchRequest.getShowtimeId () != null && !searchRequest.equals (""))
            queryBuilder.setShowtimeId (searchRequest.getShowtimeId ());
        if (searchRequest.getTicketCategory () != null && !searchRequest.equals (""))
            queryBuilder.setTicketCategory (searchRequest.getTicketCategory ());
        if (searchRequest.getSeatNo () != null && !searchRequest.equals (""))
            queryBuilder.setSeatNo (searchRequest.getSeatNo ());
//        if (searchRequest.getMovieDate () != null)
//            queryBuilder.setTicketDate (searchRequest.getT);
        return queryBuilder;
    }
}
