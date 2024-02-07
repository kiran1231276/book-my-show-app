package com.example.BookingService.dto;


import com.example.BookingService.entity.SeatBooking;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDto {


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

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private List<SeatBooking> seatBookings;


}

