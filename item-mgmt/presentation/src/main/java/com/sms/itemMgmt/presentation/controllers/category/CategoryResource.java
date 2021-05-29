package com.sms.itemMgmt.presentation.controllers.category;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//
//@RestApiController
@RequestMapping(value = "/category")
public interface CategoryResource {
    @PostMapping
    void saveCategory();
}
