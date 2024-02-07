package com.example.TicketService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {

    private String ticketId;
    private String bookingId;
    private String userId;
    private String movieId;
    private String hallId;
    private String showtimeId;
    private LocalDate ticketDate;
    private List<String> seatNumber;
    private String bookingStatus;
    private List<String> seatType;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
