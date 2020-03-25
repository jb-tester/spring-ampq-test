package com.mytests.spring.ampq.springampqtest;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Service;

import static com.mytests.spring.ampq.springampqtest.MyConfig.Q2;

/**
 * *******************************
 * Created by irina on 2/18/2020.
 * Project: spring-ampq-test
 * *******************************
 */
@Service
public class MessageListeners {

   @RabbitListener(queues = {"myQueue1"}, group = "mygroup")
    public void receiveFromQueue1(Message message) {

        System.out.println("**********************************");
        System.out.println("MessageListeners.receiveFromQueue1:");
        System.out.println(message.toString());
        System.out.println("**********************************");
    }
   @RabbitListener(queues = {Q2,"myQueue3"}, group = "mygroup2")   // navigation to queues when constants are used is incorrect
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
    
    @RabbitListener(group = "mygroup2", queues = "myQueue7")  // no completion
    public void receiveFromQueuesAdmin(Message message) {
        System.out.println("**********************************");
        System.out.println("MessageListeners.receiveFromQueuesAdmin:");
        System.out.println(message.toString());
        System.out.println("**********************************");
    }
}
