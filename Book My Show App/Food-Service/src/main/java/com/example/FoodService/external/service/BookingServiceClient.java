package com.example.FoodService.external.service;

import com.example.FoodService.dto.BookingInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BOOKING-SERVICE")
public interface BookingServiceClient {

    @GetMapping("/api/v1/bookings/{bookingId}")
    BookingInfoDto getUserIdByBookingId(@PathVariable String bookingId);

}
