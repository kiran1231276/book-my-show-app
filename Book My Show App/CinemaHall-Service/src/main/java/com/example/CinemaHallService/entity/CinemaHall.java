package com.example.CinemaHallService.entity;

import com.example.CinemaHallService.Enum.HallType;
import com.example.CinemaHallService.Enum.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cinemaHall_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaHall {

    @Id
    private String hallId;
    private String hallName;
    private String location;
    private Integer seatingCapacity;
//  private Integer availableSeats;
//    @Enumerated(EnumType.STRING)
    private List<String> seatType;
    private Integer screens;
    @Enumerated(EnumType.STRING)
    private HallType hallType;
}
