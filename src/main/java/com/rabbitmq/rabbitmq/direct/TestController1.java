package com.rabbitmq.rabbitmq.direct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mq1")
public class TestController1 {
    @Autowired
    private MQSender1 mqSender;

    @RequestMapping("/direct")
    @ResponseBody
    public String mq(){
        mqSender.send("hello world");
        return "success";
    }


}