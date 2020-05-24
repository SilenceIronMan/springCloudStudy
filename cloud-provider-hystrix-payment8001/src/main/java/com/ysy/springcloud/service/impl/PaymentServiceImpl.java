package com.ysy.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ysy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @anthor silenceYin
 * @date 2020/5/24 - 4:20
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "线程池 ：" + Thread.currentThread().getName() + " paymentInfo_Ok,id : " + id;
    }

    /**
     * 超时
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {
        Long timeout = 3L;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 ：" + Thread.currentThread().getName() + " paymentInfo_Timeout,id : " + id + "耗时(秒) O(∩_∩)O" + timeout;
    }


    /**
     * 超时
     *
     * @param id
     * @return
     */
    private String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池 ：" + Thread.currentThread().getName() + " paymentInfo_Timeout,id : 系统繁忙" + id + "耗时(秒) /(ㄒoㄒ)/~~";
    }


    // 服务熔断

    /**
     * 在10秒窗口期中10次请求有6次是请求失败的,断路器将起作用
     *
     * @param id
     * @return
     */
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期/时间范文
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率达到多少后跳闸
    }
    )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id不能是负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号:" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数,请稍后重试,o(╥﹏╥)o id:" + id;
    }
}
