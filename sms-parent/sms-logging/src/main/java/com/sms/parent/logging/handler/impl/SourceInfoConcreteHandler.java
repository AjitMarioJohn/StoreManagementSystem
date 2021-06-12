package com.sms.parent.logging.handler.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sms.common.utils.JacksonUtils;
import com.sms.parent.logging.handler.LogHandler;
import com.sms.parent.logging.utils.ParameterDescriptor;
import org.apache.logging.log4j.core.LogEvent;

public class SourceInfoConcreteHandler extends LogHandler {
    @Override
    protected ObjectNode createLogNode(ObjectMapper objectMapper, LogEvent logEvent) {
        final StackTraceElement source = logEvent.getSource();
        ObjectNode node = JacksonUtils.createJsonObjectNode.apply(objectMapper);
        node.put(ParameterDescriptor.FILE_NAME, source.getFileName());
        node.put(ParameterDescriptor.MODULE_NAME, source.getModuleName());
        node.put(ParameterDescriptor.MODULE_VERSION, source.getModuleVersion());
        node.put(ParameterDescriptor.CLASS_NAME, source.getClassName());
        node.put(ParameterDescriptor.METHOD_NAME, source.getFileName());
        node.put(ParameterDescriptor.LINE_NUMBER, source.getLineNumber());
        return node;
    }
}
