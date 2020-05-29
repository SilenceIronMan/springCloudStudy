package com.ysy.alibabacloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @anthor silenceYin
 * @date 2020/5/29 - 23:02
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumer83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer83.class, args);
    }
}
