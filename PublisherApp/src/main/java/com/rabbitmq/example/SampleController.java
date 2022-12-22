package com.rabbitmq.example;

import com.rabbitmq.example.model.Student;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private static final String EXCHANGE_NAME = "sample.exchange";

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sample/queue")
    public String samplePublish() {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "sample.key", "RabbitMQ + Springboot = Success!");
        return "message sending!";
    }

    // 객체 메시지큐 테스트
    @GetMapping("/sample/student")
    public String objectPublish() {

        Student student = new Student(1, "홍길동", 20, "서울특별시 강남구", "010-1234-5678");

        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "sample.key", student);
        return "object sending!";
    }

}
