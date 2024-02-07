package brainworks.student.externalService;

import brainworks.student.payload.response.CinemaHallDto;
import brainworks.student.payload.response.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient("USER-SERVICE")
public interface UserService {
        @GetMapping("/api/v1/users/{userId}")
        UserDto getUserById(@PathVariable String userId);

}
