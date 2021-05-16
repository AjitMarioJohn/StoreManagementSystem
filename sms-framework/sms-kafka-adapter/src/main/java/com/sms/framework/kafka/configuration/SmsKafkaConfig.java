package com.sms.framework.kafka.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty("com.sms.kafka")
public class SmsKafkaConfig {
    public String topic;
    public String bootstrapAddress;
    public int partitions;
    public int replicas;
}
