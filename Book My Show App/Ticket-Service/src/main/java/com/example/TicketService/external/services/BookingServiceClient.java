package com.example.TicketService.external.services;

import com.example.TicketService.dto.BookingInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BOOKING-SERVICE")
public interface BookingServiceClient {

    @GetMapping("/api/v1/bookings/{bookingId}")
    BookingInfoDto getBookingInfo(@PathVariable String bookingId);
}
