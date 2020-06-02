package com.ysy.springcloud.controller;

import com.ysy.springcloud.domain.CommonResult;
import com.ysy.springcloud.domain.Order;
import com.ysy.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @anthor silenceYin
 * @date 2020/6/2 - 1:20
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;


    @PostMapping("/order/create")
    @GlobalTransactional(name = "ysy-create-order", rollbackFor = Exception.class)
    public CommonResult create(@RequestBody Order order) {
        orderService.create(order);
        return new CommonResult(200, "create Order success!!!");
    }
}
