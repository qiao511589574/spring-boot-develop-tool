package com.timocode.portal.controller;

import com.timocode.rabbitmq.producer.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitMQController {
    @Autowired
    private MsgProducer msgProducer;

    @GetMapping("/first")
    public void first(){
        msgProducer.sendMsg("first message test");
    }

    @GetMapping("/all")
    public void all(){
        msgProducer.sendAll("this is all messages");
    }

    @GetMapping("/topic")
    public void send1(){
        msgProducer.send1("this is send1 message");
        msgProducer.send2("this is send2 message");
    }
}
