package com.rabbitmq.rabbitmq.faout;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQSender3 {
    private static Logger log = LoggerFactory.getLogger(MQSender3.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendFanout(Object message){
        log.info("send fanout msg:{}",message);
        amqpTemplate.convertAndSend(MQConfig3.FANOUT_EXCHANGE_NAME,"",message);
    }
}
