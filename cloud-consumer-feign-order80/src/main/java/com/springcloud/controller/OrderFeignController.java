package com.springcloud.controller;

import com.springcloud.common.entity.Payment;
import com.springcloud.common.resp.CommonResult;
import com.springcloud.services.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/testFeignTimeOut")
    public String testFeignTimeOut() {
        return paymentFeignService.testFeignTimeOut();
    }
}
