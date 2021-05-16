package com.sms.framework.commons.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.framework.commons.constant.HttpHeaderConstant;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RestController
//value = "${sms.rest.base-api}"
@RequestMapping(value = "${sms.rest.base-api}", produces = {HttpHeaderConstant.APPLICATION_JSON_UTF8_VERSION_1,
        HttpHeaderConstant.APPLICATION_HAL_JSON_VERSION_1})
public @interface RestApiController {

}
