package com.example.ShowTimeService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatInfoDto {

    private  String hallId;
    private Integer seatingCapacity;
}
