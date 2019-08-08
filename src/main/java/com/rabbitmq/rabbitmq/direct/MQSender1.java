package com.rabbitmq.rabbitmq.direct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
@Slf4j
public class MQSender1 {
    private static Logger log = LoggerFactory.getLogger(MQSender1.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(Object message){
        amqpTemplate.convertAndSend(MQConfig1.DIRECT_QUEUE_NAME,message);
        log.info("send:{}",message);
    }
}
