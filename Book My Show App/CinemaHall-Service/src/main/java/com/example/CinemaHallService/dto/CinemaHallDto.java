package com.example.CinemaHallService.dto;

import com.example.CinemaHallService.Enum.HallType;
import com.example.CinemaHallService.Enum.SeatType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CinemaHallDto {

    private String hallId;

    @NotBlank(message = "Name cannot be blank")
    private String hallName;

    @NotBlank(message = "Location cannot be blank")
    private String location;

    @NotNull(message = "Seating capacity cannot be null")
    private Integer seatingCapacity;

    @NotBlank
    private List<String> seatType;

    @NotBlank
    private HallType hallType;

    @NotNull(message = "Number of screens cannot be null")
    private Integer screens;



}
