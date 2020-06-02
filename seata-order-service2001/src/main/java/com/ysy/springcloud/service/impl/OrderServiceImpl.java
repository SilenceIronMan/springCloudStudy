package com.ysy.springcloud.service.impl;

import com.ysy.springcloud.dao.OrderDao;
import com.ysy.springcloud.domain.CommonResult;
import com.ysy.springcloud.domain.Order;
import com.ysy.springcloud.service.AccountService;
import com.ysy.springcloud.service.OrderService;
import com.ysy.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @anthor silenceYin
 * @date 2020/6/2 - 1:17
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    public void create(Order order) {
        // 1 新建订单
        log.info("1 ----> 创建订单--------");
        orderDao.create(order);

        // 2 扣减库存
        log.info("2 ----> 订单微服务调用库存服务 扣减库存 --------start");
        CommonResult decrease = storageService.decrease(order.getProductId(), order.getCount());
        log.info("2 ----> 订单微服务调用库存服务 扣减库存 --------end");

        // 3 扣减余额
        log.info("3----> 订单微服务调用账户服务 扣减金额 --------start");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("3----> 订单微服务调用账户服务 扣减金额 --------end");

        // 4 修改订单状态  0 -> 1
        log.info("4 ----> 修改订单状态 start--------");
        orderDao.update(order.getUserId(), 0);

        log.info("4 ----> 修改订单状态 end--------");

        log.info("-----下订单结束O(∩_∩)O哈哈~");
    }

    @Override
    public void update(Long userId, Integer status) {
         orderDao.update(userId, status);
    }
}
