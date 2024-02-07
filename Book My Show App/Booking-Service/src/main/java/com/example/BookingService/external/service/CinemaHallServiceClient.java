package com.example.BookingService.external.service;

import com.example.BookingService.dto.CinemaHallInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CINEMAHALL-SERVICE")
public interface CinemaHallServiceClient {

    @GetMapping("/api/v1/cinema-halls/{hallId}")
    CinemaHallInfoDto getCinemaHallById(@PathVariable String hallId);
}
