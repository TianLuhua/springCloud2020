package com.tlh.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLOUD-PAYMENT-HYSTRIX-SERVICE" ,fallback = PaymentHystrixFallBack.class)
public interface IPaymentHystrixService {

    @GetMapping("/payment/hystrix/payment/ok/{id}")
    String paymentInfoOK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/payment/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);

}
