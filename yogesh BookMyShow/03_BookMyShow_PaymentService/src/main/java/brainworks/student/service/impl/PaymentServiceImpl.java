package brainworks.student.service.impl;

import brainworks.student.entity.Payment;
import brainworks.student.payload.PaymentDto;
import brainworks.student.payload.PaymentResponse;
import brainworks.student.repository.PaymentRepository;
import brainworks.student.service.PaymentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Override
    public PaymentResponse processPayment(PaymentDto paymentDto) {
        PaymentResponse paymentResponse=new PaymentResponse ();
        paymentResponse.setPaymentId (UUID.randomUUID ().toString ());
        paymentResponse.setPaymentStatus ("Success");
        paymentResponse.setAmount (paymentDto.getAmount ());
        //.setCreateDate ("");
        paymentResponse.setUserId (paymentDto.getUserId ());
        paymentResponse.setPaymentId (UUID.randomUUID ().toString ());
        paymentResponse.setBookingId (paymentDto.getBookingId ());
        Payment payment=new Payment ();
        BeanUtils.copyProperties (paymentResponse,payment);
        Payment saved = paymentRepository.save (payment);
        BeanUtils.copyProperties (saved,paymentResponse);
        return paymentResponse;
    }

    @Override
    public String statusPayment(String paymentId) {
        return null;
    }

    @Override
    public String refundPayment(String paymentId) {
        return null;
    }

}
