package com.example.FoodService.dto;

import com.example.FoodService.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodDto {

    private String orderId;
    private String bookingId;
    private String userId;
    private List<FoodItem> foodItems;
    private Double totalAmount;
}
