package com.sms.itemMgmt.infra.query;

import com.sms.itemMgmt.infra.entities.CategoryData;

import java.util.Optional;
import java.util.UUID;

public interface CategoryQuery {
    Optional<CategoryData> findByName(String name);
    Optional<CategoryData> findById(UUID id);
}
