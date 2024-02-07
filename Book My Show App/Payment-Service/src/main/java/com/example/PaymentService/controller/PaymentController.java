package com.example.PaymentService.controller;

import com.example.PaymentService.dto.PaymentDto;
import com.example.PaymentService.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/")
    public ResponseEntity<PaymentDto> makePayment(@Valid @RequestBody PaymentDto paymentDto) {
        PaymentDto processPayment = paymentService.makePayment(paymentDto);
        return new ResponseEntity<>(processPayment, HttpStatus.CREATED);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDto> getPaymentById(@PathVariable String paymentId){
        PaymentDto paymentById = paymentService.getPaymentById(paymentId);
        return ResponseEntity.ok(paymentById);
    }

    public ResponseEntity <List<PaymentDto>> getAllPayment(){
        List<PaymentDto> allPaymentList = paymentService.getAllPayment();
        return ResponseEntity.ok(allPaymentList);
    }
}
