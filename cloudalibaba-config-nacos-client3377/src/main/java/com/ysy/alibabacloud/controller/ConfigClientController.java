package com.ysy.alibabacloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @anthor silenceYin
 * @date 2020/5/30 - 0:29
 */
@RestController
@RefreshScope // config 动态刷新
@Slf4j
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        log.info("configInfo:---------" + configInfo);
        return configInfo;
    }
}
