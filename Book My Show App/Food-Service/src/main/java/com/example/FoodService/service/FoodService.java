package com.example.FoodService.service;

import com.example.FoodService.dto.FoodDto;

import java.util.List;

public interface FoodService {

    FoodDto createFoodOrder(FoodDto foodDto);
    List<FoodDto> getAllFoodOrderDetails();
    List<FoodDto> getOrderFoodById(String orderId);
}
