package com.ysy.springcloud.controller;

import com.ysy.springcloud.entities.CommonResult;
import com.ysy.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @anthor silenceYin
 * @date 2020/5/21 - 22:40
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderConsulController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/payment/consul")
    public String paymentInfo() {
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }
}
