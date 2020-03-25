package com.mytests.spring.ampq.springampqtest;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static com.mytests.spring.ampq.springampqtest.MyConfig.Q4;

@Component
public class MyService {


  public static final String Q6 = "myQueue6";

  @RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = Q4, durable = "true"),
        exchange = @Exchange(value = "my.topic4", ignoreDeclarationExceptions = "true"),
        key = "q4")
  )
  public void processQ4(Message message) {
    System.out.println("-----------MySpelService.processQ4------------"+message);
  }

  @RabbitListener(bindings = @QueueBinding(
        value = @Queue,
        exchange = @Exchange(value = "my.topic0"),
        key = "q")
  )
  public void processQ(Message message) {
    System.out.println("--------------MySpelService.processQ---------"+message);
  }


  @RabbitListener(queuesToDeclare = @Queue(name = Q6, durable = "true")
  )
  public void processQ6(Message message) {

    System.out.println("------------MySpelService.processQ6-----"+message);
  }
}