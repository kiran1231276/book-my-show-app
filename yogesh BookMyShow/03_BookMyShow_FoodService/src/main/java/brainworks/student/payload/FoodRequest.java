package brainworks.student.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequest {

    private String foodId;
    @NotNull
    @NotEmpty
    private String itemName;
    @NotNull
    @NotEmpty
    private String bookingId;
    @NotNull
    @NotEmpty
    private String userId;
    @NotNull
    private Integer itemQty;
    @NotNull
    private Double ItemPrice;
    @NotNull
    private Double totalAmount;
}
