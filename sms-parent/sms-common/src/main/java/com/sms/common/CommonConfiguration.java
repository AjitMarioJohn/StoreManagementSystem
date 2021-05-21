package com.sms.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackageClasses = CommonConfiguration.class)
@PropertySource("classpath:application.yml")
public class CommonConfiguration {
}
