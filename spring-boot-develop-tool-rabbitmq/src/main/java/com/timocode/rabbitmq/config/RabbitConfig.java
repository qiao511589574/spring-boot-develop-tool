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

@Configuration
@Slf4j
public class RabbitConfig {

    public static final String EXCHANGE_A = "my-mq-exchange_A";
    public static final String EXCHANGE_B = "my-mq-exchange_B";
    public static final String EXCHANGE_C = "my-mq-exchange_C";
    public static final String FANOUT_EXCHANGE = "my-mq-exchange_FANOUT";

    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";
    public static final String QUEUE_C = "QUEUE_C";

    public static final String ROUTINGKEY_A = "spring-boot-rootingKey_A";
    public static final String ROUTINGKEY_B = "spring-boot-rootingKey_B";
    public static final String ROUTINGKEY_C = "spring-boot-rootingKey_C";

    @Bean(name = "firstConnectionFactory")
    @Primary
    public ConnectionFactory firstConnectionFactory(
            @Value("${spring.rabbitmq.host}") String host,
            @Value("${spring.rabbitmq.port}") int port,
            @Value("${spring.rabbitmq.username}") String username,
            @Value("${spring.rabbitmq.password}") String password,
            @Value("${spring.rabbitmq.virtualhost}") String virtualhost
    ){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualhost);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(@Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }

    @Bean
    public DirectExchange ExchangeA() {
        return new DirectExchange(EXCHANGE_A);
    }
    @Bean
    public DirectExchange ExchangeB() {
        return new DirectExchange(EXCHANGE_B);
    }
    @Bean
    public DirectExchange ExchangeC() {
        return new DirectExchange(EXCHANGE_C);
    }

    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_A, true);
    }
    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_B, true);
    }
    @Bean
    public Queue queueC() {
        return new Queue(QUEUE_C, true);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queueA()).to(ExchangeA()).with(RabbitConfig.ROUTINGKEY_A);
    }
    @Bean
    public Binding bindingB(){
        return BindingBuilder.bind(queueB()).to(ExchangeA()).with(RabbitConfig.ROUTINGKEY_B);
    }


    //广播模式
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange(RabbitConfig.FANOUT_EXCHANGE);
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
