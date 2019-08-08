package com.rabbitmq.rabbitmq.topic;



import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQReceiver2 {
    private static Logger log = LoggerFactory.getLogger(MQSender2.class);

    @RabbitListener(queues = MQConfig2.TOPIC_QUEUE_NAME1)
    public void receiveTopic1(String message){
        log.info("topic queue1 receive:{}",message);
    }

    @RabbitListener(queues = MQConfig2.TOPIC_QUEUE_NAME2)
    public void receiveTopic2(String message){
        log.info("topic queue2 receive:{}",message);
    }
}
