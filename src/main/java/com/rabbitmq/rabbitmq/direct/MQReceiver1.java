package com.rabbitmq.rabbitmq.direct;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQReceiver1 {
    private static Logger log = LoggerFactory.getLogger(MQSender1.class);

    @RabbitListener(queues = MQConfig1.DIRECT_QUEUE_NAME)
    public void receive(String message){
        log.info("receive:{}",message);
    }
}
