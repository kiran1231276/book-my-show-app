package brainworks.student.controller;


import brainworks.student.payload.request.SearchRequest;
import brainworks.student.payload.request.TicketRequest;
import brainworks.student.payload.response.SearchResponse;
import brainworks.student.payload.response.TicketResponse;
import brainworks.student.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("/bookTicket")
    public ResponseEntity<TicketResponse> createTicket(@Valid @RequestBody TicketRequest ticketRequest){
        TicketResponse ticket = ticketService.createTicket (ticketRequest);
        return new ResponseEntity<> (ticket,HttpStatus.CREATED);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponse> geticketById(@PathVariable String ticketId){
        TicketResponse ticketById = ticketService.getTicketById (ticketId);
        return new ResponseEntity<> (ticketById, HttpStatus.OK);
    }

    @GetMapping("/allTickets")
    public ResponseEntity<List<TicketResponse>> getAllTicket(){
        List<TicketResponse> allTicket = ticketService.getAllTicket ();
        return new ResponseEntity<> (allTicket, HttpStatus.OK);
    }

    @GetMapping("/getAllTicketsbyUserId/{userId}")
    public ResponseEntity<List<TicketResponse>> getAllTicketsbyUserId(@PathVariable String userId){
        List<TicketResponse> allTicketByBookingId = ticketService.getAllTicketByUserId (userId);
        return new ResponseEntity<> (allTicketByBookingId, HttpStatus.OK);
    }

    @PostMapping("/checkBookedTickets")
    public ResponseEntity<List<SearchResponse>> checkBookedTickets(@Valid @RequestBody SearchRequest searchRequest){
        List<SearchResponse> searchResponses = ticketService.checkBookedTickets (searchRequest);
        return new ResponseEntity<> (searchResponses, HttpStatus.OK);
    }

    @PutMapping("/mapBooking/{ticketId}")
    public ResponseEntity<TicketResponse> mapBooking(@PathVariable String ticketId,@RequestBody TicketRequest ticketRequest){
        TicketResponse ticketResponse = ticketService.mapBooking (ticketId, ticketRequest);
        return new ResponseEntity<> (ticketResponse, HttpStatus.OK);
    }

    @GetMapping("/getAllTicketByBookingId/{bookingId}")
    public ResponseEntity<List<TicketResponse>> getAllTicketByBookingId(@PathVariable String bookingId){
        List<TicketResponse> allTicketByBookingId = ticketService.getAllTicketByBookingId (bookingId);
        return new ResponseEntity<> (allTicketByBookingId, HttpStatus.OK);
    }
}
