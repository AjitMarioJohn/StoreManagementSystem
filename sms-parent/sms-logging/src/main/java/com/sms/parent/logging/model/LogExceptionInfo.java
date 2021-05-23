package com.sms.parent.logging.model;

import lombok.Builder;

@Builder
public final class LogExceptionInfo {
    private String cause;
    private String exception;
    private String stacktrace;
}
