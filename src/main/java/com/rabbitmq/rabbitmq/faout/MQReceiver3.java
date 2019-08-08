package com.rabbitmq.rabbitmq.faout;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQReceiver3 {
    private static Logger log = LoggerFactory.getLogger(MQSender3.class);

    @RabbitListener(queues = MQConfig3.FANOUT_QUEUE_NAME1)
    public void receiveFanout1(String message){
        log.info("fanout queue1 receive:{}",message);
    }

    @RabbitListener(queues = MQConfig3.FANOUT_QUEUE_NAME2)
    public void receiveFanout2(String message){
        log.info("fanout queue2 receive:{}",message);
    }
}
