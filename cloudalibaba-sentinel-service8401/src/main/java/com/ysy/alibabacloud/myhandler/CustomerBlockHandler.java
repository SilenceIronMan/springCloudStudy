package com.ysy.alibabacloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ysy.springcloud.entities.CommonResult;

/**
 * @anthor silenceYin
 * @date 2020/5/31 - 20:09
 */
public class CustomerBlockHandler {
    // 必须static
    public static CommonResult handlerException1(BlockException e) {
        return new CommonResult(444, "客户自定义 1 服务不可用!");
    }
    // 必须static
    public static CommonResult handlerException2(BlockException e) {
        return new CommonResult(444, "客户自定义 2 服务不可用!");
    }
}
