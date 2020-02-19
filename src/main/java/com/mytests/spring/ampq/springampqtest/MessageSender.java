package com.mytests.spring.ampq.springampqtest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * *******************************
 * Created by irina on 2/18/2020.
 * Project: spring-ampq-test
 * *******************************
 */
@Service
public class MessageSender {


    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 3000L)
    public void sendMessage1() {
        String message = "message1";
         // some navigating to the matching bindings and queues could be provided?
         // some completion for routing keys?...
        rabbitTemplate.convertAndSend("my.topic1","foo.bar" , message);
        rabbitTemplate.convertAndSend("my.topic2","bar.bar" , message);
        rabbitTemplate.convertAndSend("my.topic2","bar.foo" , message);
       // rabbitTemplate.convertAndSend("myAdminExchange","boo.dummy" , message);
        
    }
}
