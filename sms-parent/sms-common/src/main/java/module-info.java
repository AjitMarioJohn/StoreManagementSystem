module com.sms.parent.common {
    requires spring.web;
    requires lombok;
    requires spring.context;
    requires com.fasterxml.jackson.databind;

    exports com.sms.common.annotations;
    exports com.sms.common.utils;
    exports com.sms.common.models;
}