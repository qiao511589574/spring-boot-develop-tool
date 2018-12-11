package com.timocode.rabbitmq.receiver;

import com.timocode.rabbitmq.config.DirectRabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = DirectRabbitConfig.QUEUE_B)
public class MsgReceiverB1 {

    @RabbitHandler
    public void process(String content){
        log.info(this.getClass().getName()+"接受处理队列B当中的消息："+content);
    }

}
