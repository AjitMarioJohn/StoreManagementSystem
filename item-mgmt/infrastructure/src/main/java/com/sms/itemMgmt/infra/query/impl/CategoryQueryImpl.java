package com.sms.itemMgmt.infra.query.impl;

import com.sms.itemMgmt.infra.entities.CategoryData;
import com.sms.itemMgmt.infra.query.CategoryQuery;
import com.sms.itemMgmt.infra.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CategoryQueryImpl implements CategoryQuery {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryQueryImpl (CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<CategoryData> findByName (String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Optional<CategoryData> findById (UUID id) {
        return categoryRepository.findById(id);
    }
}
