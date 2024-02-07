package com.example.ShowTimeService.external.service;

import com.example.ShowTimeService.dto.SeatInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CINEMAHALL-SERVICE")
public interface HallServiceClient {

    @GetMapping("/api/v1/cinema-halls/{hallId}")
    SeatInfoDto getSeatCapacity(@PathVariable String hallId);
}