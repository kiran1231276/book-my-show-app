package brainworks.student.payload.response;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodResponse {
    @NotNull
    @NotEmpty
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
    @NotEmpty
    private Integer itemQty;
    @NotNull
    private Double ItemPrice;
    @NotNull
    private Double totalAmount;
}
