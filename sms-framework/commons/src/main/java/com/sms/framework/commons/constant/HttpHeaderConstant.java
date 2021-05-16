package com.sms.framework.commons.constant;

import java.util.UUID;

public final class HttpHeaderConstant {

    private HttpHeaderConstant() {
        throw new UnsupportedOperationException();
    }

    /*
     * are used inside request accept header
     */
    public static final String APPLICATION_JSON_VERSION_1 = "application/json, application/*+json;version=1";

    /*
     * are used inside response content type header
     */
    public static final String APPLICATION_JSON_UTF8_VERSION_1 = "application/json;version=1;charset=utf-8";

    /*
     * are used inside response content type header
     */
    public static final String APPLICATION_HAL_JSON_VERSION_1 = "application/hal+json;version=1;charset=utf-8";

}
