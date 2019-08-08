package com.rabbitmq.rabbitmq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfig2 {
    private static Logger log = LoggerFactory.getLogger(MQSender2.class);

    //queue1名字
    public static final String TOPIC_QUEUE_NAME1 = "queue_topic1";
    //queue2名字
    public static final String TOPIC_QUEUE_NAME2 = "queue_topic2";
    //交换机名字
    public static final String TOPIC_EXCHANGE_NAME = "topic_Exchange";
    //key等于topic.key1的，后面将配置为只被queue1接收
    private static final String TOPIC_KEY_ROUTE1 = "topic.key1";
    //key匹配topic.#的都被接收进queue2
    private static final String TOPIC_KEY_ROUTE2 = "topic.#";



    //创建两个QUEUE对象queue1，queue2的bean被spring管理
    @Bean
    public Queue topicQueue1(){
        return new Queue(TOPIC_QUEUE_NAME1,true);
    }
    @Bean
    public Queue topicQueue2(){
        return new Queue(TOPIC_QUEUE_NAME2,true);
    }
    //交换机
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }
    //queue1--交换机--匹配规则1
    @Bean
    public Binding topicBinding1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(TOPIC_KEY_ROUTE1);
    }
    //queue2--交换机--匹配规则2
    @Bean
    public Binding topicBinding2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(TOPIC_KEY_ROUTE2);
    }
}
