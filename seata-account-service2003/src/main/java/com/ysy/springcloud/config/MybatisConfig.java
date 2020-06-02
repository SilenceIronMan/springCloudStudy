package com.ysy.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @anthor silenceYin
 * @date 2020/6/2 - 20:56
 */
@Configuration
@MapperScan("com.ysy.springcloud.dao")
public class MybatisConfig {
}
