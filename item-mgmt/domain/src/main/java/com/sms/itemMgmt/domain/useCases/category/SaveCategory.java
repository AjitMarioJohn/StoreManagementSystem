package com.sms.itemMgmt.domain.useCases.category;

import com.sms.framework.commons.exception.InvalidUniqueId;
import com.sms.itemMgmt.domain.entities.Category;
import com.sms.itemMgmt.domain.exceptions.InvalidNameException;
import com.sms.itemMgmt.domain.useCases.UseCase;
import com.sms.itemMgmt.infra.command.CategoryCommand;
import com.sms.itemMgmt.infra.query.CategoryQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCategory extends UseCase<SaveCategory.InputValues, SaveCategory.OutputValues> {

    private final CategoryCommand categoryCommand;
    private final CategoryQuery categoryQuery;

    @Autowired
    public SaveCategory (CategoryCommand categoryCommand, CategoryQuery categoryQuery) {
        this.categoryCommand = categoryCommand;
        this.categoryQuery = categoryQuery;
    }

    @Override
    public OutputValues execute (InputValues input) throws InvalidNameException, InvalidUniqueId {
        Category category = null;
        if(input.getId() == null)
            Category.of(input.getName());
        else
            Category.of(input.getId(), input.getName());

//        categoryCommand.persist(category.toData());
        return new OutputValues(category);
    }

    public static final class InputValues implements UseCase.InputValues {
        private final String id;
        private final String name;
        private final String status;

        public InputValues (String id, String name, String status) {
            this.id = id;
            this.name = name;
            this.status = status;
        }

        public String getId () {
            return id;
        }

        public String getName () {
            return name;
        }

        public String getStatus () {
            return status;
        }
    }


    public static final class OutputValues implements UseCase.OutputValues{
        private final Category category;

        public OutputValues (Category category) {
            this.category = category;
        }

        public Category getCategory () {
            return category;
        }
    }

}
