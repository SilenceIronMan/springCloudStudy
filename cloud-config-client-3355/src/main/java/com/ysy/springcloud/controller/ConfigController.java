package com.ysy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @anthor silenceYin
 * @date 2020/5/26 - 22:29
 */
@RestController
@Slf4j
@RefreshScope
public class ConfigController {

    @Value("${my.name}")
    private String myName;

    @RequestMapping("/config/showMyName")
    public String showMyName() {
        return myName;
    }
}
