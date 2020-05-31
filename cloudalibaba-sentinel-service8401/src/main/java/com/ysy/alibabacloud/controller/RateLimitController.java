package com.ysy.alibabacloud.controller;

import cn.hutool.core.lang.UUID;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ysy.alibabacloud.myhandler.CustomerBlockHandler;
import com.ysy.springcloud.entities.CommonResult;
import com.ysy.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @anthor silenceYin
 * @date 2020/5/31 - 19:32
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "byResource_handler")
    public CommonResult byResource() {
        return new CommonResult<>(200, "按资源名称限流测试ok!", new Payment(1L, "SERIAL1"));
    }


    public CommonResult byResource_handler(BlockException e) {
        return new CommonResult(444, "服务不可用!");
    }


    @GetMapping("/rateLimit/byURL")
    @SentinelResource(value = "byURL")
    public CommonResult byURL() {
        return new CommonResult<>(200, "按URL限流测试ok!", new Payment(1L, "SERIAL2"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult<>(200, "按客户自定义限流测试ok!", new Payment(1L, "SERIAL3"));
    }


}
