package com.example.ShowTimeService.repository;

import com.example.ShowTimeService.dto.ShowTimeDto;
import com.example.ShowTimeService.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime, String> {
   /* @Query("SELECT new com.example.ShowTimeService.dto.ShowTimeDto(s.showTimeId, s.movieId, s.hallId, s.startTime, s.endTime, s.availableSeats) " +
            "FROM ShowTime s " +
            "WHERE s.hallId = :hallId")
    List<ShowTimeDto> findShowTimesByCinemaHallId(@Param("hallId") String hallId);*/

   /* @Query("SELECT new com.example.ShowTimeService.dto.ShowTimeDto(s.showTimeId, s.movieId, s.hallId, s.startTime, s.endTime, s.availableSeats) " +
            "FROM ShowTime s " +
            "WHERE s.movieId = :movieId")
    List<ShowTimeDto> findShowTimesByMovieId(@Param("movieId") String movieId);*/


//    @Query("SELECT new com.example.ShowTimeService.dto.ShowTimeDetailsDto(s, m, h) " +
//            "FROM ShowTime s " +
//            "JOIN com.example.MovieService.entity.Movie m ON s.movieId = m.movieId " +
//            "JOIN com.example.CinemaHallService.entity.CinemaHall h ON s.hallId = h.hallId")
//    List<ShowTimeDetailsDto> getShowtimeDetails();

}
