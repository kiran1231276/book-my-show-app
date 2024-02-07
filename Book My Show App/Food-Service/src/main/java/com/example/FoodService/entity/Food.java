package com.example.FoodService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "food_tbl")
public class Food {

    @Id
    private String orderId;
    private String bookingId;
    private String userId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "food_items", joinColumns = @JoinColumn(name = "order_id"))
    private List<FoodItem> foodItems;

    private Double totalAmount;


}
