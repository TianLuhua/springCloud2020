package com.tlh.springcloud.service;

import com.tlh.springcloud.entities.CommonResult;
import com.tlh.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@Component
public interface IPaymentService {

//    int create(Payment payment);

    @RequestMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    String paymentTimeOut();
}
