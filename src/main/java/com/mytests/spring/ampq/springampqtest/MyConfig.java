package com.mytests.spring.ampq.springampqtest;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * *******************************
 * Created by irina on 2/18/2020.
 * Project: spring-ampq-test
 * *******************************
 */
@Configuration
public class MyConfig {
    //public static final String Q1 = "myQueue1";
    public static final String Q2 = "myQueue2";
    //public static final String Q3 = "myQueue3";
    public static final String TOPIC_1 = "my.topic1";
    public static final String TOPIC_2 = "my.topic2";

    // exchanges:
    // to check:  use constants - from same or different class
    
    @Bean
    public TopicExchange topic1() {
        return new TopicExchange(TOPIC_1);
    }
    
    @Bean
    public TopicExchange topic2(){
        return new TopicExchange("my.topic2");
    }
   
    // queues:
    // to check: 1. use constants - from same or different class
    //           2. use same names for diff queues ?
    
    @Bean
    public Queue que1() {
        return new Queue("myQueue1");
    }
    @Bean
    public Queue que2() {
        return new Queue(Q2);
    }
    @Bean
    public Queue que3() {
        return new Queue(MyConstants.Q3);
    }
    
    // bindings
    // no args completion when using constructor

    @Bean
    public Binding bind1() {
        return new Binding("myQueue1", Binding.DestinationType.QUEUE, "my.topic1","foo.*",null);
    }

    @Bean
    public Binding bind2() {
        return BindingBuilder.bind(que2()).to(topic2()).with("bar.*");
    }
    @Bean
    public Binding bind3() {
        return BindingBuilder.bind(que3()).to(topic2()).with("bar.foo");
    }
    
    // template - to test completion
    // comment-out to run the app

    /*@Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange("my.topic1");
        rabbitTemplate.setDefaultReceiveQueue("myQueue1");     // no completion here!
        return rabbitTemplate;
    }*/
    
    // admin
    @Bean
    public RabbitAdmin admin(ConnectionFactory connectionFactory){
        RabbitAdmin admin = new RabbitAdmin(connectionFactory);
        /*TopicExchange exchange = new TopicExchange("myAdminExchange");
        admin.declareExchange(exchange);
        Queue queue = new Queue("adminQueue");
        admin.declareBinding(
                BindingBuilder.bind(queue).to(exchange).with("boo.*"));
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.convertAndSend("myAdminExchange","boo.dummy", "hello dummy admin");*/
        return admin;
    }
}
