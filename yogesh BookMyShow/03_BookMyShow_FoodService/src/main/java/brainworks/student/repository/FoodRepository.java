package brainworks.student.repository;

import brainworks.student.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,String> {
}
