package com.example.PaymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment_tbl")
public class Payment {

    @Id
    private String paymentId;

    @NotBlank(message = "UserId cannot be blank")
    private String userId;

    @NotBlank(message = "BookingId cannot be blank")
    private String bookingId;

    @NotNull(message = "Amount cannot be null")
    private Double amount;

    private String paymentMode;

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
