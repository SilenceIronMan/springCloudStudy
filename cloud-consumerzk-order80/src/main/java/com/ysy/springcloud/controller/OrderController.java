package com.ysy.springcloud.controller;

import com.ysy.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @anthor silenceYin
 * @date 2020/5/21 - 0:46
 */
@RestController
@Slf4j
public class OrderController {
    public static  final  String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/zk")
    public String paymentInfo() {
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
