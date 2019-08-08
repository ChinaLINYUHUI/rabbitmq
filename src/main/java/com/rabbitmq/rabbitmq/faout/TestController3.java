package com.rabbitmq.rabbitmq.faout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mq3")
public class TestController3 {
    @Autowired
    private MQSender3 mqSender;

    @RequestMapping("/faout")
    @ResponseBody
    public String mq(){
        mqSender.sendFanout("hello world");
        return "success";
    }


}