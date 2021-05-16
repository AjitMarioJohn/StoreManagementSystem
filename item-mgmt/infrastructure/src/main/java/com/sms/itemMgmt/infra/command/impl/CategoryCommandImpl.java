package com.sms.itemMgmt.infra.command.impl;

import com.sms.itemMgmt.infra.command.CategoryCommand;
import com.sms.itemMgmt.infra.entities.CategoryData;
import com.sms.itemMgmt.infra.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandImpl implements CategoryCommand {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryCommandImpl (CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void persist (CategoryData categoryData) {
        categoryRepository.save(categoryData);
    }
}
