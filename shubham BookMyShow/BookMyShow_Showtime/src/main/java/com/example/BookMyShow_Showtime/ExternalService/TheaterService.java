package com.example.BookMyShow_Showtime.ExternalService;


import com.example.BookMyShow_Showtime.Entity.Theaters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "THEATER-SERVICE")
public interface TheaterService {

    @GetMapping("/api/theaters/{id}")
    public Theaters getThaera(@PathVariable String id);


}
