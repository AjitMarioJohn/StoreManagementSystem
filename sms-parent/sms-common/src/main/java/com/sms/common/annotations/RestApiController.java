package com.sms.common.annotations;

import com.sms.common.constant.HttpHeaderConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RestController
@RequestMapping(value = "${sms.rest.base-api}", produces = {HttpHeaderConstant.APPLICATION_JSON_UTF8_VERSION_1,
        HttpHeaderConstant.APPLICATION_HAL_JSON_VERSION_1})
public @interface RestApiController {
}
