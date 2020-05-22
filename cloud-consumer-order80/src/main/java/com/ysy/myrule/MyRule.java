package com.ysy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @anthor silenceYin
 * @date 2020/5/22 - 22:54
 */
@Configuration
public class MyRule {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
