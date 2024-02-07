package com.example.BookingService.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CinemaHallInfoDto {

    private String hallId;
    private String hallName;
    private String location;
    private Integer seatingCapacity;
    private List<String> seatType;

}
