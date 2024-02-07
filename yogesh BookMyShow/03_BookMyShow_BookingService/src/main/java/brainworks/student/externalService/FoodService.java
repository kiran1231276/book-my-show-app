package brainworks.student.externalService;

import brainworks.student.payload.request.FoodRequest;
import brainworks.student.payload.response.FoodResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient("FOOD-SERVICE")
public interface FoodService {
    @PostMapping("/api/v1/foods/")
    FoodResponse orderFood(@Valid @RequestBody FoodRequest foodRequest);
}
