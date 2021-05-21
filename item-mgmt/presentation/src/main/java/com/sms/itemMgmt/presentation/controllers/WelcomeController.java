package com.sms.itemMgmt.presentation.controllers;

import com.sms.common.annotations.RestApiController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestApiController
public class WelcomeController {

//    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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
