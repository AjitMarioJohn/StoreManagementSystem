package com.sms.itemMgmt.infra.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "category")
@Table(name = "category")
@AllArgsConstructor
public class CategoryData {
    @Id
    private UUID pk;
    private String name;
    private String status;

    public UUID getPk () {
        return pk;
    }

    public String getName () {
        return name;
    }

    public String getStatus () {
        return status;
    }

}
