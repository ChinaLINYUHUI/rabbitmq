package com.rabbitmq.rabbitmq.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mq2")
public class TestController2 {
    @Autowired
    private MQSender2 mqSender;

    @RequestMapping("/topic")
    @ResponseBody
    public String mq_topic(){
        mqSender.sendTopic("hello world");
        return "success";
    }


}