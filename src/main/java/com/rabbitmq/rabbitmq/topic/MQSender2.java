package com.rabbitmq.rabbitmq.topic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQSender2 {
    private static Logger log = LoggerFactory.getLogger(MQSender2.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    //消息1与topic.key1和topic.#都匹配；
//消息2与topic.key1不匹配，只与topic.#匹配，那么只能被queue2接收
    public void sendTopic(Object message){
        log.info("send topic msg:{}",message);
        amqpTemplate.convertAndSend(MQConfig2.TOPIC_EXCHANGE_NAME,"topic.key1",message+"--1");
        amqpTemplate.convertAndSend(MQConfig2.TOPIC_EXCHANGE_NAME,"topic.key2",message+"--2");
    }
}
