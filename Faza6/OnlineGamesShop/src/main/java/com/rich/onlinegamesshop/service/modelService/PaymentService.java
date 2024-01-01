package com.rich.onlinegamesshop.service.modelService;


import com.rich.onlinegamesshop.model.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getAllPayments();
    void addPayment(Payment payment);
}
