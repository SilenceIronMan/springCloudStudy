package com.ysy.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ysy.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @anthor silenceYin
 * @date 2020/5/24 - 12:56
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
//@DefaultProperties(defaultFallback = "paymentInfoGlobalCallback")
public class PaymentHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_Ok(id);
        log.info("result hystrix openfeign:----:" + result);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
   // @HystrixCommand
  /*  @HystrixCommand(fallbackMethod = "paymentInfoTimeoutCallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })*/
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        log.info("result hystrix openfeign:----:" + result);
        return result;
    }

    /**
     * 特殊降級
     * @param id
     * @return
     */
    private String paymentInfoTimeoutCallback(Integer id) {

        return "系统繁忙 80调用超时";
    }

    /**
     * 全局降級
     *
     * @return
     */
    private String paymentInfoGlobalCallback() {

        return "全局 系统繁忙 80调用超时";
    }
}
