package com.mytests.spring.ampq.springampqtest;

import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Collection;

@SpringBootApplication
@EnableScheduling
@ImportResource("classpath:/rabbit-config.xml")
public class SpringAmpqTestApplication implements CommandLineRunner {
   @Autowired
    ApplicationContext ctx;
    public static void main(String[] args) {
        SpringApplication.run(SpringAmpqTestApplication.class, args);
    }

    @Autowired @Qualifier("mygroup")
    Collection<MessageListenerContainer> mygroup;
    @Autowired @Qualifier("mygroup2")
    Collection<MessageListenerContainer> mygroup2;
    @Override
    public void run(String... args) throws Exception {
        for (MessageListenerContainer container : mygroup) {
            System.out.println("************************");
            System.out.println("mygroup: "+container.toString());
            System.out.println("************************");
        }
        for (MessageListenerContainer container : mygroup2) {
            System.out.println("************************");
            System.out.println("mygroup2: "+container.toString());
            System.out.println("************************");
        }
        /*for (String name : ctx.getBeanDefinitionNames()) {
            System.out.println(name);
        }*/
    }
}
