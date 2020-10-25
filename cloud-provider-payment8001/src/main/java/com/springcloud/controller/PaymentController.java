package com.springcloud.controller;


import com.springcloud.common.entity.Payment;
import com.springcloud.common.resp.CommonResult;
import com.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController

public class PaymentController {
    Logger log = LoggerFactory.getLogger(PaymentController.class);
    @Value("${server.port}")
    private String port;
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        System.out.println(payment);
        int result = paymentService.create(payment);
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,port:" + port, result);
        } else {
            return new CommonResult(444, "插入数据库失败,port:" + port, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：" + payment);
        if (payment != null) {  //说明有数据，能查询成功
            return new CommonResult(200, "查询成功,port:" + port, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id + ",port:" + port, null);
        }
    }

    @GetMapping("/payment/test/feignTimeOut")
    public String testFeignTimeOut() {
        log.info("----------------------------------------------/payment/test/feignTimeOut");
        return "testFeignTimeOut,port:" + port;
    }

    @GetMapping("/payment/lb")
    public String getPaymentById() {
        log.info("---------------------------------------------/payment/lb");
        return "/payment/lb:" + port;
    }
}
