package com.example.TicketService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Ticket_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
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
