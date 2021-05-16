module sms.kafka.adapter {
    requires lombok;
    requires org.slf4j;
    requires spring.kafka;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires kafka.clients;

    exports com.sms.framework.kafka.consumer;
    exports com.sms.framework.kafka.producers;
}