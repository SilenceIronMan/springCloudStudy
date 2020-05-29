package com.ysy.alibabacloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @anthor silenceYin
 * @date 2020/5/29 - 21:43
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String echo(@PathVariable("id") String id) {
        return "Hello Nacos Discovery " + serverPort + "id :" + id;
    }
}
