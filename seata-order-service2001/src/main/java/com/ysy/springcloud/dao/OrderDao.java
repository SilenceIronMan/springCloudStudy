package com.ysy.springcloud.dao;

import com.ysy.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @anthor silenceYin
 * @date 2020/6/2 - 0:54
 */
@Mapper
public interface OrderDao {

    /**
     * 新建 订单
     *
     * @param order
     */
    int create(Order order);

    /**
     * 修改订单状态  0 -> 1
     *
     * @return
     */
    int update(@Param("userId") Long userId, @Param("status") Integer status);
}
