package com.rabbitmq.rabbitmq.header;

import com.rabbitmq.rabbitmq.faout.MQSender3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mq4")
public class TestController4 {
    @Autowired
    private MQSender4 mqSender;

    @RequestMapping("/header")
    @ResponseBody
    public String mq(){
        mqSender.sendHeaders("hello world");
        return "success";
    }


}