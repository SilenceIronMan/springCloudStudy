package com.ysy.springcloud.service;

/**
 * @anthor silenceYin
 * @date 2020/5/24 - 4:19
 */
public interface PaymentService {
    /**
     * 正常
     * @param id
     * @return
     */
    String paymentInfo_Ok(Integer id);

    /**
     * 超时
     * @param id
     * @return
     */
    String paymentInfo_Timeout(Integer id);

}
