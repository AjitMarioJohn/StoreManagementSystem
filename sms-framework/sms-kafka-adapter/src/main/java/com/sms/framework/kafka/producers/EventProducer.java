package com.sms.framework.kafka.producers;

import com.sms.framework.kafka.configuration.SmsKafkaConfig;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public EventProducer(
            KafkaTemplate<String, String> kafkaTemplate
    ){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishEvents(String event){
//        this.kafkaTemplate.send(SmsKafkaConfig.topic, event);
    }
}
