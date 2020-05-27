package com.ysy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @anthor silenceYin
 * @date 2020/5/28 - 1:01
 */
@EnableBinding(Sink.class)
@Slf4j
public class ReceiverMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消費者端口號：" + serverPort + "消息為：" + message.getPayload());

    }
}
