package brainworks.student.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private String paymentId;
    private String userId;
    private  String bookingId;
    private Double amount;
    private  String paymentStatus;
    private LocalDate createDate;
}
