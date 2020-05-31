package com.ysy.alibabacloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @anthor silenceYin
 * @date 2020/5/29 - 23:02
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumer84 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer84.class, args);
    }
}
