package com.tlh.springcloud.controller;

import com.tlh.springcloud.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HystrixPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private HystrixPaymentService paymentService;

    @GetMapping("/payment/hystrix/payment/ok/{id}")
    public String paymentOK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentOK(id);
        log.info(result);
        return result;
    }

    @GetMapping("/payment/hystrix/payment/timeout/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentTimeOut(id);
        log.info(result);
        return result;
    }
}
