package com.sms.framework.kafka.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.kafka.config.TopicBuilder;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SmsKafkaTopicConfig {

    private final SmsKafkaConfig smsKafkaConfig;

    public SmsKafkaTopicConfig(SmsKafkaConfig smsKafkaConfig) {
        this.smsKafkaConfig = smsKafkaConfig;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, smsKafkaConfig.bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic smsTopic() {
//        return new NewTopic(smsKafkaConfig.topic, 1, (short) 1);
        return TopicBuilder.name(smsKafkaConfig.topic)
                .partitions(smsKafkaConfig.partitions)
                .replicas(smsKafkaConfig.replicas)
                .build();
    }

}
