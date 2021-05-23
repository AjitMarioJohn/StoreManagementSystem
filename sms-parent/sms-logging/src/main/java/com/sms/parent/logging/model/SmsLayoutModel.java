package com.sms.parent.logging.model;

import lombok.Builder;

@Builder
public final class SmsLayoutModel {
    private String level;
    private String thread;
    private String threadId;
    private String loggerName;
    private String serviceName;
    private String version;
    private String hostName;
    private String hostAddress;
    private LogSourceInfo sourceInfo;
    private LogExceptionInfo exceptionInfo;
    private String message;
    private String logDateTime;
}
