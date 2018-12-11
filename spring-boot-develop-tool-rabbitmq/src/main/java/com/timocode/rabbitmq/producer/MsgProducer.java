package com.timocode.rabbitmq.producer;

import com.timocode.rabbitmq.config.FanoutRabbitConfig;
import com.timocode.rabbitmq.config.DirectRabbitConfig;
import com.timocode.rabbitmq.config.TopicRabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class MsgProducer implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }

    public void sendMsg(String content){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(DirectRabbitConfig.EXCHANGE_A, DirectRabbitConfig.ROUTINGKEY_A, content, correlationData);
    }

    public void sendAll(String content){
        rabbitTemplate.convertAndSend(FanoutRabbitConfig.FANOUT_EXCHANGE,"",content);
    }

    public void send1(String content){
        rabbitTemplate.convertAndSend(TopicRabbitConfig.topicExchange,"topic.message",content);
    }
    public void send2(String content){
        rabbitTemplate.convertAndSend(TopicRabbitConfig.topicExchange,"topic.messages",content);

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
