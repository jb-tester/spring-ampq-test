package com.mytests.spring.ampq.springampqtest;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Service;

/**
 * *******************************
 * Created by irina on 2/18/2020.
 * Project: spring-ampq-test
 * *******************************
 */
@Service
public class MessageListeners {

    

    @RabbitListener(queues = {"myQueue1"})
    public void receiveFromQueue1(Message message) {
        System.out.println("**********************************");
        System.out.println("MessageListeners.receiveFromQueue1:");
        System.out.println(message.toString());
        System.out.println("**********************************");
    }
    @RabbitListener(queues = {"myQueue2","myQueue3"})   // navigation to queues when constants are used is incorrect
    public void receiveFromQueues23(Message message) {
        System.out.println("**********************************");
        System.out.println("MessageListeners.receiveFromQueues23:");
        System.out.println(message.toString());
        System.out.println("**********************************");
    }
    @RabbitListeners({      // no completion and navigation here! Method is shown as not used!
            @RabbitListener(queues = "myQueue1"),     
            @RabbitListener(queues = "myQueue2"),     
            @RabbitListener(queues = "myQueue3")     
    })
    public void receiveFromQueues(Message message) {
        System.out.println("**********************************");
        System.out.println("MessageListeners.receiveFromQueues:");
        System.out.println(message.toString());
        System.out.println("**********************************");
    }
    
    @RabbitListener(admin = "admin")  // no completion
    public void receiveFromQueuesAdmin(Message message) {
        System.out.println("**********************************");
        System.out.println("MessageListeners.receiveFromQueuesAdmin:");
        System.out.println(message.toString());
        System.out.println("**********************************");
    }
}
