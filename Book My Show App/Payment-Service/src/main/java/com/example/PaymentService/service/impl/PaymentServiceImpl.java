package com.example.PaymentService.service.impl;

import com.example.PaymentService.dto.PaymentDto;
import com.example.PaymentService.entity.Payment;
import com.example.PaymentService.exception.ResourceNotFoundException;
import com.example.PaymentService.repository.PaymentRepository;
import com.example.PaymentService.service.PaymentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentDto makePayment(PaymentDto paymentDto) {
        paymentDto.setPaymentId(UUID.randomUUID().toString());
        Payment payment = new Payment();
        mapDtoToEntity(paymentDto, payment);

        Payment savedPayment = paymentRepository.save(payment);
        return mapEntityToDto(savedPayment);
    }

    @Override
    public PaymentDto getPaymentById(String paymentId) {
        Optional<Payment> byId = paymentRepository.findById(paymentId);
        if(byId.isPresent()){
            return mapEntityToDto(byId.get());
        }
        else throw new ResourceNotFoundException("Given payment id is not found..."+paymentId);
    }

    @Override
    public List<PaymentDto> getAllPayment() {
        return null;
    }


    //  map DTO to entity
    private void mapDtoToEntity(PaymentDto paymentDto, Payment payment) {
        BeanUtils.copyProperties(paymentDto, payment);
    }

    // map entity to DTO
    private PaymentDto mapEntityToDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        BeanUtils.copyProperties(payment, paymentDto);
        return paymentDto;
    }
}
