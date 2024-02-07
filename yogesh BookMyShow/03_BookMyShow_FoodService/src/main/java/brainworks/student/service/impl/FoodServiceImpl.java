package brainworks.student.service.impl;

import brainworks.student.entity.Food;
import brainworks.student.payload.FoodRequest;
import brainworks.student.payload.FoodResponse;
import brainworks.student.repository.FoodRepository;
import brainworks.student.service.FoodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;
    @Override
    public FoodResponse orderFood(FoodRequest foodRequest) {
        foodRequest.setFoodId (UUID.randomUUID ().toString ());
        foodRequest.setTotalAmount (foodRequest.getItemPrice ()*foodRequest.getItemQty ());
        Food foodOrdered=new Food ();
        BeanUtils.copyProperties (foodRequest,foodOrdered);
        Food save = foodRepository.save (foodOrdered);
        FoodResponse foodResponse=new FoodResponse ();
        BeanUtils.copyProperties (save,foodResponse);
        return foodResponse;
    }

    @Override
    public List<FoodResponse> getAllFoodOrderBYBookingId(String bookingId) {
        return null;
    }
}
