package com.springcloud.service.imp;

import com.springcloud.service.PaymentHystrixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceImp implements PaymentHystrixService {
    private Logger log = LoggerFactory.getLogger(PaymentHystrixService.class);

    @Override
    public String paymentInfo_OK(Integer id) {
        log.info("order:hystrix ok");
        return "线程池：" + Thread.currentThread().getName() + "  order:paymentInfo_Ok,id：  " + "\t" + "呜呜呜呜呜呜呜呜呜" + " 耗时(秒)";

    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        log.info("order:hystrix timeout");
        return "线程池：" + Thread.currentThread().getName() + "  order:paymentInfo_TimeOut,id：  " + "\t" + "呜呜呜呜呜呜呜呜呜" + " 耗时(秒)";
    }
}
