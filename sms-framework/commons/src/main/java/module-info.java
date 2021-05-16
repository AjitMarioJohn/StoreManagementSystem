module com.sms.framework.commons {
    requires spring.web;
    requires lombok;
    requires spring.context;

    exports com.sms.framework.commons.constant;
    exports com.sms.framework.commons.annotations;
    exports com.sms.framework.commons.exception;
}