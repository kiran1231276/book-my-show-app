package com.example.FoodService.controller;

import com.example.FoodService.dto.FoodDto;
import com.example.FoodService.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/")
    public ResponseEntity<FoodDto> createFoodOrder(@RequestBody FoodDto foodDto){
        FoodDto foodOrder = foodService.createFoodOrder(foodDto);
        return new ResponseEntity<>(foodOrder, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<FoodDto>> getAllFoodOrderDetails(){
        List<FoodDto> allFoodOrderDetails = foodService.getAllFoodOrderDetails();
        return ResponseEntity.ok(allFoodOrderDetails);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<List<FoodDto>> getOrderFood(@PathVariable String orderId) {
        List<FoodDto> foodDtoList = foodService.getOrderFoodById(orderId);
        return ResponseEntity.ok(foodDtoList);
    }
}
