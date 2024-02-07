package com.example.BookingService.repository;

import com.example.BookingService.dto.BookingDto;
import com.example.BookingService.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    @Query("SELECT new com.example.BookingService.dto.BookingDto(b.bookingId, b.userId, b.movieId, b.hallId, b.showTimeId, b.bookingDateTime, b.startDateTime, b.endDateTime, b.totalAmount, b.numberOfSeatsBooked, b.bookingStatus) FROM Booking b WHERE b.userId = :userId")
    List<Booking> findByUserId(@Param("userId") String userId);

    @Query("SELECT new com.example.BookingService.dto.BookingDto(b.bookingId, b.userId, b.movieId, b.hallId, b.showTimeId, b.bookingDateTime, b.startDateTime, b.endDateTime, b.totalAmount, b.numberOfSeatsBooked, b.bookingStatus) FROM Booking b WHERE b.movieId = :movieId")
    List<Booking> findByMovieId(@Param("movieId") String movieId);

    @Query("SELECT new com.example.BookingService.dto.BookingDto(b.bookingId, b.userId, b.movieId, b.hallId, b.showTimeId, b.bookingDateTime, b.startDateTime, b.endDateTime, b.totalAmount, b.numberOfSeatsBooked, b.bookingStatus) FROM Booking b WHERE b.hallId = :hallId")
    List<Booking> findByHallId(@Param("hallId") String hallId);

    @Query("SELECT new com.example.BookingService.dto.BookingDto(b.bookingId, b.userId, b.movieId, b.hallId, b.showTimeId, b.bookingDateTime, b.startDateTime, b.endDateTime, b.totalAmount, b.numberOfSeatsBooked, b.bookingStatus) FROM Booking b WHERE b.showTimeId = :showTimeId")
    List<Booking> findByShowTimeId(@Param("showTimeId") String showTimeId);
}
