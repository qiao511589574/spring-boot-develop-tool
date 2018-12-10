package com.timocode.rabbitmq.producer;

import com.timocode.rabbitmq.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class MsgProducer implements RabbitTemplate.ConfirmCallback {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }

    public void sendMsg(String content){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationData);
    }

    public void sendAll(String content){
        rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE,"",content);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info("回调id:"+ correlationData);
        if (b) {
            log.info("消息消费成功");
        } else {
            log.info("消息消费失败："+s);
        }
    }
}
