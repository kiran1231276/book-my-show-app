package com.example.BookingService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "booking_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
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

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "seat_bookings", joinColumns = @JoinColumn(name = "booking_id"))
    private List<SeatBooking> seatBookings;

}
