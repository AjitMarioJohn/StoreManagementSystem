package com.sms.parent.logging.model;

import lombok.Builder;

@Builder
public final class LogSourceInfo {
    private String className;
    private String methodName;
    private String fileName;
    private String lineNumber;
}
