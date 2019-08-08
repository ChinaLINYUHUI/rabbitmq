package com.rabbitmq.rabbitmq.header;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQSender4 {
    private static Logger log = LoggerFactory.getLogger(MQSender4.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendHeaders(Object message){
        String msg = Bean.beanToString(message);
        log.info("send fanout msg:{}",message);
        MessageProperties properties = new MessageProperties();
        properties.setHeader("header1","value1");
        properties.setHeader("header2","value2");
        Message obj = new Message(msg.getBytes(),properties);
        amqpTemplate.convertAndSend(MQConfig4.HEADERS_EXCHANGE_NAME,"",obj);
    }
}
