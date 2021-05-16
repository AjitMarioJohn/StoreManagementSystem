module itemMgmt.infrastructure {
    requires java.persistence;
    requires lombok;
    requires spring.data.jpa;
    requires spring.context;
    requires spring.beans;

    exports com.sms.itemMgmt.infra.entities to itemMgmt.domain;
    exports com.sms.itemMgmt.infra.command to itemMgmt.domain;
    exports com.sms.itemMgmt.infra.query;
}