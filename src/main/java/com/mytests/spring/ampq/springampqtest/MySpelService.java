package com.mytests.spring.ampq.springampqtest;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MySpelService {

    @RabbitListener(queues = "#{'${property.with.comma.delimited.queue.names}'.split(',')}" )
    public void processSpel1(Message message) {
        System.out.println("----------------------------------------");
        System.out.println("MySpelService.processSpel1");
        System.out.println(message);
        System.out.println("----------------------------------------");
    }
    @RabbitListener(queues = "#{@que8}" )
    public void processSpel2(Message message) {
        System.out.println("----------------------------------------");
        System.out.println("MySpelService.processSpel2");
        System.out.println(message);
        System.out.println("----------------------------------------");
    }
    @Bean
    public Queue que8() {
        return new Queue("myQueue8");
    }
    @Bean
    public Queue que9() {
        return new Queue("myQueue9");
    }

    @Bean
    public Binding bindSpel1() {
        return BindingBuilder.bind(que8()).to(spel_topic()).with("xxx");
    }
    @Bean
    public Binding bindSpel2() {
        return BindingBuilder.bind(que9()).to(spel_topic()).with("yyy");
    }

    @Bean
    public TopicExchange spel_topic() {
        return new TopicExchange("spel.topic");
    }

}