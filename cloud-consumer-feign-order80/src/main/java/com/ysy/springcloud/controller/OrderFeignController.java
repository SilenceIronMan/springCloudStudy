package com.ysy.springcloud.controller;

import com.ysy.springcloud.entities.CommonResult;
import com.ysy.springcloud.entities.Payment;
import com.ysy.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @anthor silenceYin
 * @date 2020/5/23 - 22:20
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        return paymentFeignService.getPaymentById(id);

    }

    @RequestMapping("/consumer/payment/feign/timeout")
    public String getPaymentFeignTimeout() {
        // 客户端一般默认等待一分钟
        return paymentFeignService.getPaymentFeignTimeout();
    }
}
