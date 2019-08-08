package com.rabbitmq.rabbitmq.header;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class MQConfig4 {
    private static Logger log = LoggerFactory.getLogger(MQSender4.class);

    public static final String HEADERS_EXCHANGE_NAME = "headersExchage";
    public static final String HEADERS_QUEUE_NAME = "headers.queue";

    @Bean
    public HeadersExchange headersExchange(){
        return new HeadersExchange(HEADERS_EXCHANGE_NAME);
    }
    @Bean
    public Queue headersQueue(){
        return new Queue(HEADERS_QUEUE_NAME,true);
    }
    //就是说要完全匹配这个Map才能进入queue中发送出去
    @Bean
    public Binding headersBinding(){
        Map<String,Object> map = new HashMap<>();
        map.put("header1","value1");
        map.put("header2","value2");
        return BindingBuilder.bind(headersQueue()).to(headersExchange()).whereAll(map).match();
    }
}
