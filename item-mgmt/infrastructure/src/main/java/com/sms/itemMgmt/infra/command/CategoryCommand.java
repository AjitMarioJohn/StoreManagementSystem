package com.sms.itemMgmt.infra.command;

import com.sms.itemMgmt.infra.entities.CategoryData;

public interface CategoryCommand {
    void persist(CategoryData categoryData);
}
