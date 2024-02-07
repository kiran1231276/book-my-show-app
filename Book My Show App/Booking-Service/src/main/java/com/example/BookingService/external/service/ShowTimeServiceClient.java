package com.example.BookingService.external.service;

import com.example.BookingService.dto.ShowTimeInfoDto;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "SHOWTIME-SERVICE")
public interface ShowTimeServiceClient {

    @GetMapping("/api/v1/showtimes/{showTimeId}")
    ShowTimeInfoDto getShowTimeById(@PathVariable String showTimeId);

    @PutMapping("/api/v1/showtimes/{showTimeId}")
    ShowTimeInfoDto updateShowTime(
            @PathVariable String showTimeId,
            @RequestBody ShowTimeInfoDto showTimeDto);
}
