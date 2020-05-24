package com.ysy.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @anthor silenceYin
 * @date 2020/5/24 - 12:52
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{


    @Override
    public String paymentInfo_Ok(Integer id) {
        return "===========PaymentFallbackService paymentInfo_Ok fall back";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "===========PaymentFallbackService paymentInfo_Timeout fall back";
    }
}
