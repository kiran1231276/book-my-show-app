package brainworks.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    private String foodId;
    private String bookingId;
    private String userId;
    private String itemName;
    private Integer itemQty;
    private Double ItemPrice;
    private Double totalAmount;
}
