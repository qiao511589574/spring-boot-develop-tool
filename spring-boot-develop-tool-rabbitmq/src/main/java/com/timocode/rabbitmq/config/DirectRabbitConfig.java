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
public class DirectRabbitConfig {

    //EXCHANGE
    public static final String EXCHANGE_A = "my-mq-exchange_A";
    public static final String EXCHANGE_B = "my-mq-exchange_B";
    public static final String EXCHANGE_C = "my-mq-exchange_C";

    //QUEUE
    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";
    public static final String QUEUE_C = "QUEUE_C";

    //ROUTINGKEY
    public static final String ROUTINGKEY_A = "spring-boot-rootingKey_A";
    public static final String ROUTINGKEY_B = "spring-boot-rootingKey_B";
    public static final String ROUTINGKEY_C = "spring-boot-rootingKey_C";

    /**
     * 创建ConnectionFactory
     * 可以创建多个，通过Bean name区分
     * @param host
     * @param port
     * @param username
     * @param password
     * @param virtualhost
     * @return
     */
    @Bean(name = "firstConnectionFactory")
    @Primary    //默认选用
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

    /**
     * Direct模式 RoutingKey = BindingKey
     */
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
        return BindingBuilder.bind(queueA()).to(ExchangeA()).with(DirectRabbitConfig.ROUTINGKEY_A);
    }
    @Bean
    public Binding bindingB(){
        return BindingBuilder.bind(queueB()).to(ExchangeA()).with(DirectRabbitConfig.ROUTINGKEY_B);
    }

}
