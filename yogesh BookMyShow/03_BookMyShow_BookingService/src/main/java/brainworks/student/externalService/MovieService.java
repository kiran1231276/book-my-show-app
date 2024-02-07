package brainworks.student.externalService;

import brainworks.student.payload.response.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("MOVIES-SERVICE")
public interface MovieService {
    @GetMapping("/api/v1/movies/getMovie/{movieId}")
    MovieDto getMovieById(@PathVariable String movieId);
}
