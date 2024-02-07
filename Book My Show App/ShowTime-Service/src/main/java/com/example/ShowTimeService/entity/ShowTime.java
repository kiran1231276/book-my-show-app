package com.example.ShowTimeService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "showTime_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowTime {

    @Id
    private String  showTimeId;
    private String movieId;
    private String hallId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Integer availableSeats;
}
