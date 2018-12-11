package com.timocode.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * topic模式
 */
@Configuration
@Slf4j
public class TopicRabbitConfig {

    //QUEUE
    public static final String QUEUE_message = "topic.message";
    public static final String QUEUE_messages = "topic.messages";

    //EXCHANGE
    public final static String topicExchange = "topicExchange";

    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.QUEUE_message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.QUEUE_messages);
    }

    @Bean
    TopicExchange topicexchange(){
        return new TopicExchange(TopicRabbitConfig.topicExchange);
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessages).to(topicExchange).with("topic.#");
    }


}
