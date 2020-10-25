package com.springcloud.services;

import com.springcloud.common.resp.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
@Component
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/test/feignTimeOut")
    String testFeignTimeOut();
}
