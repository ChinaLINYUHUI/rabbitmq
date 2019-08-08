package com.rabbitmq.rabbitmq.header;

import com.rabbitmq.rabbitmq.faout.MQConfig3;
import com.rabbitmq.rabbitmq.faout.MQSender3;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQReceiver4 {
    private static Logger log = LoggerFactory.getLogger(MQSender3.class);

    @RabbitListener(queues = MQConfig4.HEADERS_QUEUE_NAME)
    public void receiveHeaders(byte[] message){
        log.info("header queue receive:{}",new String(message));
    }
}
