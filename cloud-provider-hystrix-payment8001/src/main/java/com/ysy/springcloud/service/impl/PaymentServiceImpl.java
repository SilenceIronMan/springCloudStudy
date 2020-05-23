package com.ysy.springcloud.service.impl;

import com.ysy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @anthor silenceYin
 * @date 2020/5/24 - 4:20
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "线程池 ：" + Thread.currentThread().getName() + " paymentInfo_Ok,id : " + id;
    }

    /**
     * 超时
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_Timeout(Integer id) {
        Long timeout = 3L;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 ：" + Thread.currentThread().getName() + " paymentInfo_Timeout,id : " + id + "耗时(秒)" + timeout;
    }
}
