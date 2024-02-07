package brainworks.student.externalService;

import brainworks.student.payload.response.PaymentDto;
import brainworks.student.payload.response.PaymentResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PAYMENT-SERVICE")
public interface PaymentService {

    @PostMapping("/api/v1/payments/processPayment")
    PaymentResponse processPayment(@RequestBody PaymentDto paymentDto);
}
