package com.tlh.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixFallBack implements IPaymentHystrixService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "PaymentHystrixFallBack--paymentInfoOK--id:"+id;
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "PaymentHystrixFallBack--paymentInfoTimeOut--id:"+id;
    }
}
