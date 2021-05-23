package com.sms.itemMgmt.presentation.controllers;

import com.sms.common.annotations.RestApiController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestApiController
public class WelcomeController {

    private final Logger LOGGER = LogManager.getLogger(WelcomeController.class);

    @Value("${item.mgmt.welcome-msg}")
    private String welcomeMsg;

    @GetMapping
    public String welcomeMsg(){
        LOGGER.info("Welcome url info");
        LOGGER.error("Welcome url error");
        LOGGER.debug("Welcome url debug");
        return welcomeMsg;
    }

    @GetMapping(value = "/ping")
    public void ping(){

    }


}
