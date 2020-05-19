package com.ysy.springcloud.service;

import com.ysy.springcloud.entities.Payment;

/**
 * @anthor silenceYin
 * @date 2020/5/17 - 20:41
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
