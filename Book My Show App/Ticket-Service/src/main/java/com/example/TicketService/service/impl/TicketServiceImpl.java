package com.example.TicketService.service.impl;

import com.example.BookingService.entity.SeatBooking;
import com.example.TicketService.dto.BookingInfoDto;
import com.example.TicketService.dto.TicketDto;
import com.example.TicketService.entity.Ticket;
import com.example.TicketService.exception.ResourceNotFoundException;
import com.example.TicketService.external.services.BookingServiceClient;
import com.example.TicketService.repository.TicketRepository;
import com.example.TicketService.service.TicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private BookingServiceClient bookingServiceClient;

    private static final List<String> PLATINUM_SEATS = generateSeats("P", 90);
    private static final List<String> GOLD_SEATS = generateSeats("G", 80);
    private static final List<String> DIAMOND_SEATS = generateSeats("D", 80);

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        BookingInfoDto bookingInfo = bookingServiceClient.getBookingInfo(ticketDto.getBookingId());

        if (bookingInfo == null) {
            throw new ResourceNotFoundException("Booking information not found for bookingId: " + ticketDto.getBookingId());
        }

        TicketDto ticketDto1 = createTicketDto(bookingInfo);
        assignSeats(ticketDto1, bookingInfo);

        Ticket createdTicket = ticketRepository.save(mapDtoToEntity(ticketDto1));

        return convertToDto(createdTicket);
    }

    private void assignSeats(TicketDto ticketDto, BookingInfoDto bookingInfo) {
        List<SeatBooking> seatTypes = bookingInfo.getSeatBookings();
        int numSeatsBooked = bookingInfo.getNumberOfSeatsBooked();

        for (SeatBooking seatType : seatTypes) {
            List<String> availableSeats = getAvailableSeats(String.valueOf(seatType));
            List<String> selectedSeats = new ArrayList<>();

            for (int i = 0; i < numSeatsBooked; i++) {
                if (!availableSeats.isEmpty()) {
                    String selectedSeat = availableSeats.remove(0);
                    selectedSeats.add(selectedSeat);
                } else {
                    // Handle the case where there are not enough available seats
                    throw new IllegalStateException("Not enough available seats for booking.");
                }
            }

            ticketDto.getSeatType().add(String.valueOf(seatType));
            ticketDto.getSeatNumber().addAll(selectedSeats);
        }
    }

    private List<String> getAvailableSeats(String seatType) {
        switch (seatType) {
            case "Diamond":
                return DIAMOND_SEATS;
            case "Platinum":
                return PLATINUM_SEATS;
            case "Gold":
                return GOLD_SEATS;
            default:
                throw new IllegalArgumentException("Invalid seat type: " + seatType);
        }
    }

    private TicketDto createTicketDto(BookingInfoDto bookingInfo) {
        return TicketDto.builder()
                .ticketId(UUID.randomUUID().toString())
                .bookingId(bookingInfo.getBookingId())
                .userId(bookingInfo.getUserId())
                .movieId(bookingInfo.getMovieId())
                .hallId(bookingInfo.getHallId())
                .showtimeId(bookingInfo.getShowTimeId())
                .startDateTime(bookingInfo.getStartDateTime())
                .endDateTime(bookingInfo.getEndDateTime())
                .seatType(bookingInfo.getSeatType())
                .seatNumber(bookingInfo.getSeatNumber())
                .bookingStatus(bookingInfo.getBookingStatus())
                .ticketDate(LocalDate.now())
                .build();
    }

    private static List<String> generateSeats(String prefix, int numSeats) {
        return IntStream.rangeClosed(1, numSeats)
                .mapToObj(i -> prefix + i)
                .collect(Collectors.toList());
    }


    @Override
    public TicketDto getTicketById(String ticketId) {
        Optional<Ticket> byId = ticketRepository.findById(ticketId);
        return byId.map(this::convertToDto).orElseThrow(()->new ResourceNotFoundException("Resource not found with given id"+ticketId));
    }

    @Override
    public List<TicketDto> getAllTickets() {
        List<Ticket> ticketList = ticketRepository.findAll();
        return ticketList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<TicketDto> getTicketByBookingId(String bookingId) {
        Optional<Ticket> byId = ticketRepository.findById(bookingId);
        return byId.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<TicketDto> getTicketByUserId(String userId) {
        Optional<Ticket> byId = ticketRepository.findById(userId);
        return byId.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<TicketDto> getTicketByMovieId(String movieId) {
        Optional<Ticket> byId = ticketRepository.findById(movieId);
        return byId.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<TicketDto> getTicketByHallId(String hallId) {
        Optional<Ticket> byId = ticketRepository.findById(hallId);
        return byId.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<TicketDto> getTicketByShowTimeId(String showTimeId) {
        Optional<Ticket> byId = ticketRepository.findById(showTimeId);
        return byId.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // Helper method to convert Booking entity to BookingDto
    private TicketDto convertToDto(Ticket ticket) {
    TicketDto ticketDto = new TicketDto();
    BeanUtils.copyProperties(ticket, ticketDto);
        return ticketDto;
    }

    // Helper method to map BookingDto to Booking entity
    private Ticket mapDtoToEntity(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(ticketDto, ticket);
        return ticket;
    }

}
