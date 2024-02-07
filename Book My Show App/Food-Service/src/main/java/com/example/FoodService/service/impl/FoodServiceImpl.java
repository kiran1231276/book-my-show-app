package com.example.FoodService.service.impl;

import com.example.FoodService.dto.BookingInfoDto;
import com.example.FoodService.dto.FoodDto;
import com.example.FoodService.entity.Food;
import com.example.FoodService.entity.FoodItem;
import com.example.FoodService.exception.ResourceNotFoundException;
import com.example.FoodService.external.service.BookingServiceClient;
import com.example.FoodService.repository.FoodRepository;
import com.example.FoodService.service.FoodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private BookingServiceClient bookingServiceClient;

    @Override
    public FoodDto createFoodOrder(FoodDto foodDto) {

        foodDto.setOrderId(UUID.randomUUID().toString());

        // Item prices map
        Map<String, Double> itemPrices = new HashMap<>();
        itemPrices.put("Pizza", 310.0);
        itemPrices.put("Burger", 100.0);
        itemPrices.put("Popcorn", 90.0);
        itemPrices.put("WaterBottle", 50.0);
        itemPrices.put("VadaPav", 70.0);
        itemPrices.put("Wafers", 40.0);
        itemPrices.put("Pepsi", 65.0);
        itemPrices.put("MangoFruity", 85.0);
        itemPrices.put("Sandwich", 110.0);
        itemPrices.put("Samosa", 50.0);

        // Fetch userId from Booking service based on bookingId
        String bookingId = foodDto.getBookingId();
        BookingInfoDto userId = bookingServiceClient.getUserIdByBookingId(bookingId);

        // Set userId in foodDto
        foodDto.setUserId(String.valueOf(userId));

        // Calculate total amount based on items, quantities, and prices
        calculateTotalAmount(foodDto, itemPrices);

        Food food = new Food();
        mapDtoToEntity(foodDto, food);
        Food savedFood = foodRepository.save(food);
        return mapFoodToDto(savedFood);
    }

    // Helper method to calculate total amount for a food order
    private void calculateTotalAmount(FoodDto foodDto, Map<String, Double> itemPrices) {
        if (foodDto.getFoodItems() != null && !foodDto.getFoodItems().isEmpty()) {
            double totalAmount = 0.0;

            for (FoodItem foodItem : foodDto.getFoodItems()) {
                int itemQty = foodItem.getItemQty();

                // Check if the item is available and has a valid price
                if (itemPrices.containsKey(foodItem.getItemName())) {
                    double itemPrice = itemPrices.get(foodItem.getItemName());
                    double itemTotalAmount = itemQty * itemPrice;

                    // Set total amount for the current food item
                    foodItem.setTotalAmount(itemTotalAmount);

                    // Add the item total amount to the overall order total
                    totalAmount += itemTotalAmount;
                }
            }

            // Set the overall total amount for the order
            foodDto.setTotalAmount(totalAmount);
        } else {
            // Set columns to null if no item order
            foodDto.setFoodItems(null);
            foodDto.setTotalAmount(null);
        }
    }


    @Override
    public List<FoodDto> getAllFoodOrderDetails() {
        List<Food> foodList = foodRepository.findAll();

        // Convert entities to DTOs
        return foodList.stream()
                .map(this::mapFoodToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodDto> getOrderFoodById(String orderId) {
        Optional<Food> foodList = foodRepository.findById(orderId);

        if (foodList.isEmpty()) {
            throw new ResourceNotFoundException("No food orders found for the given orderId: " + orderId);
        }

        // Convert entities to DTOs
        return foodList.stream()
                .map(this::mapFoodToDto)
                .collect(Collectors.toList());
    }

    // Helper method to map DTO to entity
    private void mapDtoToEntity(FoodDto foodDto, Food food) {
        BeanUtils.copyProperties(foodDto, food);
    }

    // Helper method to map food entity to foodDto
    private FoodDto mapFoodToDto(Food food) {
        FoodDto foodDto = new FoodDto();
        BeanUtils.copyProperties(food, foodDto);
        return foodDto;
    }
}