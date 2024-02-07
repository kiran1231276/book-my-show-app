package brainworks.student.externalService;

import brainworks.student.payload.response.ShowtimeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("SHOWTIME-SERVICE")
public interface ShowtimeService {

    @GetMapping("/api/v1/showtimes/getShowtime/{showtimeId}")
    ShowtimeDto getShowtimeById(@PathVariable String showtimeId);
}
