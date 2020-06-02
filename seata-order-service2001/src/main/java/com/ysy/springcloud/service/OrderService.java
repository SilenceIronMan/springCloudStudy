package com.ysy.springcloud.service;

import com.ysy.springcloud.domain.Order;

/**
 * @anthor silenceYin
 * @date 2020/6/2 - 1:16
 */
public interface OrderService {

    /**
     * 新建 订单
     *
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态  0 -> 1
     *
     * @return
     */
    void update(Long userId, Integer status);
}
