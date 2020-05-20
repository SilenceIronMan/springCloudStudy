package com.ysy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @anthor silenceYin
 * @date 2020/5/21 - 0:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class, args);
    }
}
