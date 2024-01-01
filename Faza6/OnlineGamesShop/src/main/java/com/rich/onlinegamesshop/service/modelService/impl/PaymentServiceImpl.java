package com.rich.onlinegamesshop.service.modelService.impl;

import com.rich.onlinegamesshop.model.Payment;
import com.rich.onlinegamesshop.repository.PaymentRepository;
import com.rich.onlinegamesshop.service.modelService.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }
}
