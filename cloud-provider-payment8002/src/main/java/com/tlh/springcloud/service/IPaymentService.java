package com.tlh.springcloud.service;

import com.tlh.springcloud.entities.Payment;

public interface IPaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
