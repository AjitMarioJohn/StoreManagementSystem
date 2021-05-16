module itemMgmt.domain {
    requires com.sms.framework.commons;
    requires lombok;
    requires itemMgmt.infrastructure;
    requires spring.beans;
    requires spring.context;

    exports com.sms.itemMgmt.domain.useCases to itemMgmt.presentation;
}