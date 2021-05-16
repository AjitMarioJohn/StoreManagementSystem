package com.sms.itemMgmt.domain.valueObjects;

import com.sms.itemMgmt.domain.exceptions.InvalidNameException;
import lombok.NonNull;

public class Name {

    @NonNull
    private final String name;


    public Name (@NonNull String name) {
        this.name = name;
    }

    public static Name of(final String name) throws InvalidNameException {
        if (name != null && name.trim().isEmpty())
            throw new InvalidNameException("Name cannot be empty");
        return new Name(name);
    }

    public String getValue(){
        return this.name;
    }
}
