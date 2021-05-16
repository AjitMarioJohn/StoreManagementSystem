package com.sms.framework.commons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackageClasses = CommonsConfiguration.class)
@PropertySource("classpath:application.yml")
public class CommonsConfiguration {
}
