package com.sms.parent.logging.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.logging.log4j.core.LogEvent;

import java.util.Optional;

public abstract class LogHandler {
    private LogHandler logHandler;

    public void setLogHandler(LogHandler logHandler) {
        this.logHandler = logHandler;
    }

    public ObjectNode createSchema(ObjectMapper mapper, LogEvent logEvent){
        ObjectNode node = createLogNode(mapper, logEvent);
        return Optional.ofNullable(logHandler).map(handler -> {
            node.setAll(handler.createSchema(mapper, logEvent));
            return node;
        }).orElse(node);
    }

    protected abstract ObjectNode createLogNode(ObjectMapper mapper, LogEvent logEvent);
}
