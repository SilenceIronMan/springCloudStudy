package com.ysy.alibabacloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @anthor silenceYin
 * @date 2020/5/29 - 23:03
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceURL;


    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String echo(@PathVariable("id") String id) {
        return restTemplate.getForObject(serviceURL + "/payment/nacos/" + id, String.class);
    }
}
