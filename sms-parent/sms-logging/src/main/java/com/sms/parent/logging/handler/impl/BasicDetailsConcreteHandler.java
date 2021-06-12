package com.sms.parent.logging.handler.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sms.common.models.IPAddressModel;
import com.sms.common.utils.DateTimeUtils;
import com.sms.common.utils.IPAddressUtils;
import com.sms.common.utils.JacksonUtils;
import com.sms.parent.logging.handler.LogHandler;
import com.sms.parent.logging.utils.ParameterDescriptor;
import org.apache.logging.log4j.core.LogEvent;

import java.net.UnknownHostException;
import java.util.function.Consumer;

public class BasicDetailsConcreteHandler extends LogHandler {
    private Consumer<ObjectNode> addIpDetails = (parentNode) -> {
        IPAddressModel ipAddressModel = null;
        try {
            ipAddressModel = IPAddressUtils.getIpDetails();
        } catch (UnknownHostException e) {
            ipAddressModel = new IPAddressModel();
        }
        parentNode.put(ParameterDescriptor.HOST_NAME, ipAddressModel.getHostName());
        parentNode.put(ParameterDescriptor.HOST_ADDRESS, ipAddressModel.getHostAddress());
    };

    @Override
    public ObjectNode createLogNode(ObjectMapper mapper, LogEvent logEvent) {
        ObjectNode node = JacksonUtils.createJsonObjectNode.apply(mapper);
        this.addIpDetails.accept(node);
        node.put(ParameterDescriptor.LEVEL, logEvent.getLevel().name());
        node.put(ParameterDescriptor.THREAD, logEvent.getThreadName());
        node.put(ParameterDescriptor.THREAD_ID, String.valueOf(logEvent.getThreadId()));
        node.put(ParameterDescriptor.LOGGER_NAME, logEvent.getLoggerName());
        node.put(ParameterDescriptor.LOG_DATE_TIME, DateTimeUtils.instantDateTime.get());
        node.put(ParameterDescriptor.MESSAGE, logEvent.getMessage().getFormattedMessage());
        return node;
    }
}
