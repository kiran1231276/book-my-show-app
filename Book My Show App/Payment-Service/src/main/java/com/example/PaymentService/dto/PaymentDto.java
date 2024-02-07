package com.example.PaymentService.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {

    private String paymentId;

    @NotBlank(message = "UserId cannot be blank")
    private String userId;

    @NotBlank(message = "BookingId cannot be blank")
    private String bookingId;

    @NotNull(message = "Amount cannot be null")
    private Double amount;

    @NotNull
    private String paymentMode ;

    @NotBlank(message = "PaymentStatus cannot be blank")
    private String paymentStatus;

    // Cardholder Information
    @NotBlank(message = "CardholderName cannot be blank")
    private String cardHolderName;

    @NotBlank(message = "CardNumber cannot be blank")
    private String cardNumber;

    @NotBlank(message = "ExpiryDate cannot be blank")
    private String expiryDate;

    @NotBlank(message = "CVV cannot be blank")
    private String cvv;

    private String transactionId;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createDate;

}

