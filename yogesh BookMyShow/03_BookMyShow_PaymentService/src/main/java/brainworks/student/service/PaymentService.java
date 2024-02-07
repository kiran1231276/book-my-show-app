package brainworks.student.service;

import brainworks.student.payload.PaymentDto;
import brainworks.student.payload.PaymentResponse;

public interface PaymentService {
    PaymentResponse processPayment(PaymentDto paymentDto);
    String statusPayment(String paymentId);
    String refundPayment(String paymentId);
}
