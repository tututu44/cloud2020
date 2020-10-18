package com.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController

public class PaymentConsulController {

    Logger log = LoggerFactory.getLogger(PaymentConsulController.class);

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentConsul(){
        log.info("springcloud with consul:PaymentConsulController");
        return "springcloud with consul: "+serverPort+"---------------"+ UUID.randomUUID().toString();
    }
}
