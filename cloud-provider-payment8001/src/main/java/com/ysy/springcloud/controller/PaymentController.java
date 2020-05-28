package com.ysy.springcloud.controller;

import com.ysy.springcloud.entities.CommonResult;
import com.ysy.springcloud.entities.Payment;
import com.ysy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @anthor silenceYin
 * @date 2020/5/17 - 20:44
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入結果：" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入數據庫成功" + serverPort, result);
        } else {
            return new CommonResult<>(444, "插入數據庫失敗");
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询結果：" + payment);
        if (Objects.nonNull(payment)) {
            return new CommonResult<>(200, "查询成功" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "查询失败:id" + id);
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info(element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getHost() + instance.getPort() + instance.getUri());
        }
        return this.discoveryClient;
    }

    @RequestMapping("/lb")
    public String getPaymentLb() {
        return serverPort;
    }


    @RequestMapping("/feign/timeout")
    public String getPaymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @RequestMapping("/zipkin")
    public String getPaymentZipkin() {
        return "it's a payment zipkin test!! congratulation!";
    }

}
