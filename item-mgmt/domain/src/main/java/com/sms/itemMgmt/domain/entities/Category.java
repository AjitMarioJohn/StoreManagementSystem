package com.sms.itemMgmt.domain.entities;

import com.sms.itemMgmt.domain.exceptions.InvalidNameException;
import com.sms.itemMgmt.domain.valueObjects.Name;
import com.sms.itemMgmt.domain.valueObjects.Status;
import com.sms.itemMgmt.infra.entities.CategoryData;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
public class Category {
//    @NonNull
//    private UniqueId id;
//    @NonNull
//    private Name name;
//    private Status status;
//
//    private Category (@NonNull UniqueId id, @NonNull Name name, Status status) {
//        this.id = id;
//        this.name = name;
//        this.status = status;
//    }
//
//    public static Category of (String name) throws InvalidNameException, InvalidUniqueId {
//        return new Category(UniqueId.create(), Name.of(name), Status.ACTIVE);
//    }
//
//    public static Category of (String id, String name) throws InvalidNameException, InvalidUniqueId {
//        return new Category(UniqueId.of(id), Name.of(name), Status.ACTIVE);
//    }
//
//    public static Category from(CategoryData categoryData) throws InvalidUniqueId, InvalidNameException {
//        return new Category(UniqueId.of(categoryData.getPk().toString()), Name.of(categoryData.getName()
//        ), Status.valueOf(categoryData.getStatus()));
//    }

//    public CategoryData toData() {
//        return new CategoryData(this.id.getValue(), this.name.getValue(), this.status.toString());
//    }

//    public void setStatusToInActive(){
//        this.status = Status.INACTIVE;
//    }
//
//    public void setStatusToActive(){
//        this.status = Status.ACTIVE;
//    }
//
//    public void changeName(String name) throws InvalidNameException {
//        this.name = Name.of(name);
//    }
}
