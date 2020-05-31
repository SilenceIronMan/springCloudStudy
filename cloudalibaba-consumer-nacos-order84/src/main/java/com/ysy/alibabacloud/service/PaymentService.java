package com.ysy.alibabacloud.service;

import com.ysy.alibabacloud.service.impl.PaymentFallbackService;
import com.ysy.springcloud.entities.CommonResult;
import com.ysy.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @anthor silenceYin
 * @date 2020/6/1 - 0:24
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
