package com.sms.parent.logging.handler.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sms.common.utils.JacksonUtils;
import com.sms.parent.logging.handler.LogHandler;
import com.sms.parent.logging.utils.ParameterDescriptor;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.impl.ThrowableProxy;

import java.util.Optional;
import java.util.function.BiFunction;

public class ExceptioninfoConcreteHandler extends LogHandler {
    private BiFunction<ObjectNode, ThrowableProxy, ObjectNode> setExceptionInfo = (node, thrownProxy) -> {
        final Throwable throwable = thrownProxy.getThrowable();
        node.put(ParameterDescriptor.EXCEPTION, throwable.getClass().getCanonicalName());
        node.put(ParameterDescriptor.CAUSE, throwable.getMessage());
        node.put(ParameterDescriptor.STACK_TRACE, thrownProxy.getExtendedStackTraceAsString(""));
        return node;
    };

    @Override
    protected ObjectNode createLogNode(ObjectMapper mapper, LogEvent logEvent) {
        ObjectNode node = JacksonUtils.createJsonObjectNode.apply(mapper);
        return Optional.ofNullable(logEvent.getThrownProxy()).map(throwProxy -> this.setExceptionInfo.apply(node, throwProxy)).orElse(node);
    }
}
