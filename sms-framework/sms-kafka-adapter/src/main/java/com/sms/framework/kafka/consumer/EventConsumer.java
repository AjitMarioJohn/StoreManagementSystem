package com.sms.framework.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class EventConsumer {

    @KafkaListener(topics = "#{KafkaConfig.topic}")
    public void consume(String message) throws IOException {
        log.info(String.format("kafka message {}",message));
    }

}
