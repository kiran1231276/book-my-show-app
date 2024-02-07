package com.example.BookingService.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowTimeInfoDto {

    private String showTimeId;
    private String movieId;
    private String hallId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Integer availableSeats;
}
