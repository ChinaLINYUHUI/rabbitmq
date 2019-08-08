package com.rabbitmq.rabbitmq.direct;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Configuration
public class MQConfig1 {
    private static Logger log = LoggerFactory.getLogger(MQSender1.class);
    //MQ name
    public static final String DIRECT_QUEUE_NAME = "queue_direct";
    @Bean
    public Queue queue(){
        return new Queue(DIRECT_QUEUE_NAME,true);
    }
}
