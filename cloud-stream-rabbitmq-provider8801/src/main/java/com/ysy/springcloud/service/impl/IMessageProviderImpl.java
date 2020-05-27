package com.ysy.springcloud.service.impl;

import com.ysy.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @anthor silenceYin
 * @date 2020/5/28 - 0:28
 */
@EnableBinding(Source.class) //定义消息的推送管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("****serial:" + serial);
        return null;
    }
}
