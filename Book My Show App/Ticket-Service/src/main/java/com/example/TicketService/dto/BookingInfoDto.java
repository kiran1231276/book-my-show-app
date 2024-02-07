package com.example.TicketService.dto;

import com.example.BookingService.entity.SeatBooking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingInfoDto {

    private String bookingId;
    private String userId;
    private String movieId;
    private String hallId;
    private String showTimeId;
    private LocalDateTime bookingDateTime;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int totalAmount;

    private int numberOfSeatsBooked;

    private String bookingStatus;

    private List<String> seatNumber;

    private List<String> seatType;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private List<SeatBooking> seatBookings;


}
