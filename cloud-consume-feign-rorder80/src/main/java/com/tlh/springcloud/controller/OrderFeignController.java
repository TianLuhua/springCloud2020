package com.tlh.springcloud.controller;

import com.tlh.springcloud.entities.CommonResult;
import com.tlh.springcloud.entities.Payment;
import com.tlh.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private IPaymentService paymentService;

    @RequestMapping("/consumer/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }


}
