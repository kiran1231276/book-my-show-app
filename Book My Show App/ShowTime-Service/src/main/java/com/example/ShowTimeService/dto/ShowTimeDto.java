package com.example.ShowTimeService.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowTimeDto {

    @NotBlank(message = "ShowTimeId cannot be blank")
    private String showTimeId;

    @NotBlank(message = "MovieId cannot be blank")
    private String movieId;

    @NotBlank(message = "HallId cannot be blank")
    private String hallId;

    @NotBlank(message = "StartTime cannot be blank")
    private LocalDateTime startDateTime;

    @NotBlank(message = "EndTime cannot be blank")
    private LocalDateTime endDateTime;

    private Integer availableSeats;
}
