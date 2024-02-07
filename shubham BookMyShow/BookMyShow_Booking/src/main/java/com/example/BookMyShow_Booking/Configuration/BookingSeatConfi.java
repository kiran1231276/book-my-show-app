package com.example.BookMyShow_Booking.Configuration;

import com.example.BookMyShow_Booking.Service.BookingService;
import com.example.BookMyShow_Booking.Service.Impl.BookSeatImpl;
import com.example.BookMyShow_Booking.Service.Impl.BookSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class BookingSeatConfi {

        @Autowired
        private BookSeatImpl bookingService;

        @Scheduled(fixedRate = 300000) // Run every minute
        public void releaseExpiredSeatLocks() {
            bookingService.releaseExpiredSeatLocks();
        }
    }

