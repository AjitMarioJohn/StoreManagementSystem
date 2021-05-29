package com.sms.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class DateTimeUtils {
    private static final String DATEFORMAT = "dd-MM-yyyy hh:mm:ss";
    public static Supplier<String>  instantDateTime = () -> DateTimeFormatter.ofPattern(DATEFORMAT).format(LocalDateTime.now());
}
