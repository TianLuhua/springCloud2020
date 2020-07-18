package com.tlh.springcloud.service.impl;

import com.tlh.springcloud.dao.PaymentDao;
import com.tlh.springcloud.entities.Payment;
import com.tlh.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IPaymentServiceImpl implements IPaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
