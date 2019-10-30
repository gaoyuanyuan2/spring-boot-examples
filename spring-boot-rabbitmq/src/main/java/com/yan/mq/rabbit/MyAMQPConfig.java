package com.yan.mq.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAMQPConfig
{

    // direct:把消息投递到那些binding key与routing key完全匹配的队列中。它是完全匹配、单播的模式。

    private static final String routingKey = "all";

    // 默认java序列化，配置成json
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    //创建接收消息的队列
    @Bean
    public Queue bookQueue() {
        return new Queue("bookQueue");
    }

    //创建接收消息的Exchange，模式为Direct
    @Bean
    public DirectExchange orderNotifyExchange() {
        //durable：持久化，重启后还有。
        return new DirectExchange("bookQueue",true,false);
    }

    @Bean
    public Binding binding(Queue bookQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(bookQueue).to(directExchange).with(routingKey);
    }

}
