package com.ysy.alibabacloud.controller;

import com.ysy.springcloud.entities.CommonResult;
import com.ysy.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

/**
 * @anthor silenceYin
 * @date 2020/5/29 - 21:43
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, UUID.randomUUID().toString()));
        hashMap.put(2L, new Payment(2L, UUID.randomUUID().toString()));
        hashMap.put(3L, new Payment(3L, UUID.randomUUID().toString()));
    }


    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> echo(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);

        return new CommonResult<>(200, "from mysql, serverPort:" + serverPort, payment);
    }
}
