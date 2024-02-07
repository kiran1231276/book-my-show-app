package brainworks.student.externalService;

import brainworks.student.payload.response.CinemaHallDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CINEMA-HALL-SERVICE")
public interface CinemaHallService {
    @GetMapping("/api/v1/cinema_hall/getCinemaHall/{cinemaHallId}")
    CinemaHallDto getCinemaHallById(@PathVariable String cinemaHallId);
}
