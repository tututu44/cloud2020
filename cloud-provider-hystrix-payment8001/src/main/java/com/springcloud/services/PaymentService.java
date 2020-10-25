package com.springcloud.services;

public interface PaymentService {
    String paymentInfoOK(Integer id);

    String paymentInfoTimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);
}
