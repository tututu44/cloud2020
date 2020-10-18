package com.springcloud.service;


import com.springcloud.common.entity.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
