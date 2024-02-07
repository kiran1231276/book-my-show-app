package com.example.TicketService.service;

import com.example.TicketService.dto.TicketDto;

import java.util.List;

public interface TicketService {

    public TicketDto createTicket(TicketDto ticketDto);

    public TicketDto getTicketById(String ticketId);

    List<TicketDto> getAllTickets();

    List<TicketDto> getTicketByBookingId(String bookingId);

    List<TicketDto> getTicketByUserId(String userId);

    List<TicketDto> getTicketByMovieId(String movieId);

    List<TicketDto> getTicketByHallId(String hallId);

    List<TicketDto> getTicketByShowTimeId(String showTimeId);
}
