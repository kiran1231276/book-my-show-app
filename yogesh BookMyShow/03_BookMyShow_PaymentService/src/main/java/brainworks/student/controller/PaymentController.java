package brainworks.student.controller;

import brainworks.student.payload.PaymentDto;
import brainworks.student.payload.PaymentResponse;
import brainworks.student.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/processPayment")
    public ResponseEntity<PaymentResponse> processPayment(@Valid @RequestBody PaymentDto paymentDto){
        PaymentResponse paymentResponse = paymentService.processPayment (paymentDto);
        return new ResponseEntity<> (paymentResponse, HttpStatus.CREATED);
    }

   // public String confirmPayment(String )
}
