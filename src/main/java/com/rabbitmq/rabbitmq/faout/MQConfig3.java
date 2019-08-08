package com.rabbitmq.rabbitmq.faout;

import com.rabbitmq.rabbitmq.direct.MQSender1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfig3 {
    private static Logger log = LoggerFactory.getLogger(MQSender3.class);

    public static final String FANOUT_EXCHANGE_NAME = "fanoutExchage";
    public static final String FANOUT_QUEUE_NAME1 = "fanout.queue1";
    public static final String FANOUT_QUEUE_NAME2 = "fanout.queue2";

    @Bean
    public Queue fanoutQueue1(){
        return new Queue(FANOUT_QUEUE_NAME1,true);
    }
    @Bean
    public Queue fanoutQueue2(){
        return new Queue(FANOUT_QUEUE_NAME2,true);
    }
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE_NAME);
    }
    @Bean
    public Binding fanoutBinding1(){
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }
    @Bean
    public Binding fanoutBinding2(){
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }
}
