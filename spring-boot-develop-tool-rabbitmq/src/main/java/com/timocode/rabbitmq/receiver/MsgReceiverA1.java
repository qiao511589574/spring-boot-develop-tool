package com.timocode.rabbitmq.receiver;

import com.timocode.rabbitmq.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiverA1 {

    @RabbitHandler
    public void process(String content){
        log.info(this.getClass().getName()+"接受处理队列A当中的消息："+content);
    }

}
