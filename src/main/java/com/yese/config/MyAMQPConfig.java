package com.yese.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置类
 */
@Configuration
public class MyAMQPConfig {
    @Bean
    public MessageConverter messageConverter() {
        // json格式序列化消息体
        return new Jackson2JsonMessageConverter();
    }
}
