package com.ysy.alibabacloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ysy.springcloud.entities.CommonResult;
import com.ysy.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @anthor silenceYin
 * @date 2020/5/29 - 23:03
 */
@RestController
@Slf4j
public class CircleBreakerOrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceURL;


    @GetMapping(value = "/consumer/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback")
    public CommonResult<Payment> echo(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.exchange(serviceURL + "/paymentSQL/" + id, HttpMethod.GET,
                null, new ParameterizedTypeReference<CommonResult<Payment>>() {
                }).getBody();
        //CommonResult<Payment> result = restTemplate.getForObject(serviceURL + "/paymentSQL/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException, 非法參數異常。。。");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException, 該id沒有對應的記錄，空指針異常");
        }
        return result;
    }

    // fallback (處理java 異常 blockhandler 不會處理java 異常)
    public CommonResult<Payment> handlerFallback(Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444, "异常处理handlerFallback,exception 内容" + e.getMessage(), payment);
    }
}
