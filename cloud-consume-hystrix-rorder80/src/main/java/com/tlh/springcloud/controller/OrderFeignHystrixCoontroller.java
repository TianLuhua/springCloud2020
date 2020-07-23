package com.tlh.springcloud.controller;

import com.tlh.springcloud.service.IPaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignHystrixCoontroller {

    @Resource
    private IPaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/payment/ok/{id}")
    String paymentInfoOK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoOK(id);
    }

    @GetMapping("/consumer/payment/hystrix/payment/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoTimeOut(id);
    }
}
