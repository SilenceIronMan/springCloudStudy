package com.ysy.springcloud.service.impl;

import com.ysy.springcloud.dao.PaymentDao;
import com.ysy.springcloud.entities.Payment;
import com.ysy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @anthor silenceYin
 * @date 2020/5/17 - 20:42
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
