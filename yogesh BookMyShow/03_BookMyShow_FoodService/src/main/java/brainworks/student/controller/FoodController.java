package brainworks.student.controller;

import brainworks.student.payload.FoodRequest;
import brainworks.student.payload.FoodResponse;
import brainworks.student.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {
    @Autowired
    FoodService foodService;
    @PostMapping("/")
    public ResponseEntity<FoodResponse> orderFood(@Valid @RequestBody FoodRequest foodRequest){
        FoodResponse foodResponse = foodService.orderFood (foodRequest);
        return new ResponseEntity<> (foodResponse, HttpStatus.CREATED);
    }
}
