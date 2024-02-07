package brainworks.student.service;

import brainworks.student.payload.FoodRequest;
import brainworks.student.payload.FoodResponse;

import java.util.List;

public interface FoodService {

    FoodResponse orderFood(FoodRequest foodRequest);
    List<FoodResponse> getAllFoodOrderBYBookingId(String bookingId);
}
