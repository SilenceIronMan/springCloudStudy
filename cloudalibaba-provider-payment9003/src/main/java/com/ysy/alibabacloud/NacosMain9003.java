package com.ysy.alibabacloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @anthor silenceYin
 * @date 2020/5/29 - 21:42
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosMain9003.class, args);
    }
}
