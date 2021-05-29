/*
 This custom layout of logging done in Store Management System. This is class is designed
 using the reference of github project https://github.com/ivandzf/log4j2-custom-layout
*/
package com.sms.parent.logging.layout;

import com.sms.common.models.IPAddressModel;
import com.sms.common.utils.DateTimeUtils;
import com.sms.common.utils.IPAddressUtils;
import com.sms.common.utils.JacksonUtils;
import com.sms.parent.logging.model.LogExceptionInfo;
import com.sms.parent.logging.model.LogSourceInfo;
import com.sms.parent.logging.model.SmsLayoutModel;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.impl.ThrowableProxy;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;

import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Plugin(name = "SmsJsonLayout", category = Node.CATEGORY, elementType = Layout.ELEMENT_TYPE, printObject = true)
public final class SmsJsonLayout extends AbstractStringLayout {

    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private static final Matcher isMessageTextFormatMatcher = Pattern.compile("^((?!.*\\{.*[a-zA-Z]+.*\\}).*\\{\\d.*)*$").matcher("");
    private final String serviceName;
    private final String version;
    private Function<ThrowableProxy, LogExceptionInfo> convertToExceptionLog = (thrownProxy) -> {
        final Throwable throwable = thrownProxy.getThrowable();
        return LogExceptionInfo.builder().exception(throwable.getClass().getCanonicalName())
                .cause(throwable.getMessage()).stacktrace(thrownProxy.getExtendedStackTraceAsString("")).build();
    };

    protected SmsJsonLayout(String serviceName, String version) {
        super(UTF8);
        this.serviceName = serviceName;
        this.version = version;
    }

    @PluginFactory
    public static SmsJsonLayout createLayout(@PluginAttribute(value = "serviceName", defaultString = "") final String serviceName,
                                             @PluginAttribute(value = "version", defaultString = "") final String version) {

        return new SmsJsonLayout(serviceName, version);
    }

    @Override
    public String toSerializable(LogEvent logEvent) {
        IPAddressModel ipAddressModel = null;
        try {
            ipAddressModel = IPAddressUtils.getIpDetails();
        } catch (UnknownHostException e) {
           ipAddressModel = new IPAddressModel();
        }

        final StackTraceElement source = logEvent.getSource();
        LogSourceInfo sourceInfo = LogSourceInfo.builder().className(source.getClassName())
                                   .methodName(source.getMethodName()).fileName(source.getFileName())
                                    .lineNumber(String.valueOf(source.getLineNumber())).build();

        final LogExceptionInfo exceptionInfo = Optional.ofNullable(logEvent.getThrownProxy()).map(this.convertToExceptionLog).orElse(LogExceptionInfo.builder().build());
        SmsLayoutModel smsLayoutModel = SmsLayoutModel.builder().serviceName(this.serviceName)
                .version(this.version).hostName(ipAddressModel.getHostName())
                .hostAddress(ipAddressModel.getHostAddress()).level(logEvent.getLevel().name())
                .thread(logEvent.getThreadName()).threadId(String.valueOf(logEvent.getThreadId()))
                .loggerName(logEvent.getLoggerName()).sourceInfo(sourceInfo).logDateTime(DateTimeUtils.instantDateTime.get())
                .message(logEvent.getMessage().getFormattedMessage()).exceptionInfo(exceptionInfo).build();

//        if (hideEnvironmentWhenNull) {
//            if (!LogEnvironment.hasPort() || !LogEnvironment.hasIpAddress() || !LogEnvironment.hasApplicationName())
//                return Strings.EMPTY;
//        }
//
//        JsonObject jsonObject = new JsonObject();
//
//        // Application Name
//        if (LogEnvironment.hasApplicationName()) {
//            jsonObject.addProperty("applicationName", LogEnvironment.getApplicationName());
//        }
//
//        // Ip Address
//        if (LogEnvironment.hasIpAddress()) {
//            jsonObject.addProperty("ipAddress", LogEnvironment.getIpAddress());
//        }
//
//        // Port running
//        if (LogEnvironment.hasPort()) {
//            jsonObject.addProperty("port", LogEnvironment.getPort());
//        }
//
//        // Log Information
//        jsonObject.addProperty("level", event.getLevel().name());
//        jsonObject.addProperty("thread", event.getThreadName());
//        jsonObject.addProperty("threadId", event.getThreadId());
//        jsonObject.addProperty("loggerName", event.getLoggerName());

        // Log Location Information
//        if (locationInfo) {
//            final StackTraceElement source = event.getSource();
//
//            JsonObject sourceObject = new JsonObject();
//            sourceObject.addProperty("class", source.getClassName());
//            sourceObject.addProperty("method", source.getMethodName());
//            sourceObject.addProperty("file", source.getFileName());
//            sourceObject.addProperty("line", source.getLineNumber());
//
//            jsonObject.add("source", sourceObject);
//        }

        // Message
//        CustomMessage customMessage = JsonUtils.generateCustomMessage(event.getMessage().getFormattedMessage());
//        if (customMessage != null) {
//            jsonObject.addProperty("message", customMessage.getMessage());
//            customMessage.getNewField().forEach((k, v) -> {
//                if (v instanceof String) {
//                    jsonObject.addProperty(k, (String) v);
//                } else if (v instanceof Number) {
//                    jsonObject.addProperty(k, (Number) v);
//                } else if (v instanceof Character) {
//                    jsonObject.addProperty(k, (Character) v);
//                } else if (v instanceof Boolean) {
//                    jsonObject.addProperty(k, (Boolean) v);
//                } else {
//                    jsonObject.addProperty(k, gson.toJson(v));
//                }
//            });
//        } else {
//            jsonObject.addProperty("message", event.getMessage().getFormattedMessage());
//        }

        // Exceptions
//        if (event.getThrownProxy() != null) {
//            final ThrowableProxy thrownProxy = event.getThrownProxy();
//            final Throwable throwable = thrownProxy.getThrowable();
//
//            final String exceptionsClass = throwable.getClass().getCanonicalName();
//            if (exceptionsClass != null) {
//                jsonObject.addProperty("exception", exceptionsClass);
//            }
//
//            final String exceptionsMessage = throwable.getMessage();
//            if (exceptionsMessage != null) {
//                jsonObject.addProperty("cause", exceptionsMessage);
//            }
//
//            final String stackTrace = thrownProxy.getExtendedStackTraceAsString("");
//            if (stackTrace != null) {
//                jsonObject.addProperty("stacktrace", stackTrace);
//            }
//        }

//        return gson.toJson(jsonObject).concat("\r\n");
        return Optional.ofNullable(JacksonUtils.marshalToJSON.apply(smsLayoutModel)).orElse("") + "\n";
    }
}
