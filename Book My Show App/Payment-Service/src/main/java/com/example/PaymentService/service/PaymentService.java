package com.example.PaymentService.service;

import com.example.PaymentService.dto.PaymentDto;

import java.util.List;

public interface PaymentService {

    public PaymentDto makePayment(PaymentDto paymentDto);

    public PaymentDto getPaymentById(String paymentId);

    public List<PaymentDto> getAllPayment();
}
