package com.ysy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @anthor silenceYin
 * @date 2020/5/26 - 21:49
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3355.class, args);
    }
}
