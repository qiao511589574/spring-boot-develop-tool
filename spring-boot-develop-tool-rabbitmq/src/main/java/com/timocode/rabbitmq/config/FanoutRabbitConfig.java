package com.timocode.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;


/**
 * 广播模式/订阅模式 Fanout
 * 针对的消费者是绑定在EXCHANGE上的QUEUE
 * 而不是绑定在QUEUE上的每一个实际消费者
 * （自己的理解）
 */
@Configuration
@Slf4j
public class FanoutRabbitConfig {

    //EXCHANGE
    public static final String FANOUT_EXCHANGE = "my-mq-exchange_FANOUT";

    //QUEUE
    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";
    public static final String QUEUE_C = "QUEUE_C";

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange(FanoutRabbitConfig.FANOUT_EXCHANGE);
    }

    @Bean
    Binding bindingExchangeA(Queue queueA, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue queueB, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue queueC, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueC).to(fanoutExchange);
    }

}
