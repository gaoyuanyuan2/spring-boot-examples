package com.yan.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MsgConsumer {


    @KafkaListener(topics = { "test" })
    public void processMessage(String content) {

        System.out.println(content);

    }

}