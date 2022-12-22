package com.rabbitmq.example;

import com.rabbitmq.example.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener {

    private static final Logger log = LoggerFactory.getLogger(SampleListener.class);

//    @RabbitListener(queues = "sample.queue")
//    public void receiveMessage(final Message message) {
//        log.info(message.toString());
//    }

    @RabbitHandler
    @RabbitListener(queues = "sample.queue")
    public void receiveMessage(Student student) {
        log.info(student.toString());
        System.out.println(student.toString());
    }

}
