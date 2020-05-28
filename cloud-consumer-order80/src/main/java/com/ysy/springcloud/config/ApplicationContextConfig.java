package com.ysy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @anthor silenceYin
 * @date 2020/5/17 - 21:40
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced // 如果采用自定义注释这个
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
