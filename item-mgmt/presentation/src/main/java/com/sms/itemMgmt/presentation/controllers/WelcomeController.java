package com.sms.itemMgmt.presentation.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import com.sms.framework.commons.annotations.RestApiController;

@RestApiController
public class WelcomeController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Value("${item.mgmt.welcome-msg}")
    private String welcomeMsg;

    @GetMapping
    public String welcomeMsg(){
        return welcomeMsg;
    }

    @GetMapping(value = "/ping")
    public void ping(){

    }


}
