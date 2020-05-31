package com.ysy.alibabacloud.service.impl;

import com.ysy.alibabacloud.service.PaymentService;
import com.ysy.springcloud.entities.CommonResult;
import com.ysy.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @anthor silenceYin
 * @date 2020/6/1 - 0:27
 */
@Component
public class PaymentFallbackService implements PaymentService {
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "openFeign 服務降級！");
    }
}
