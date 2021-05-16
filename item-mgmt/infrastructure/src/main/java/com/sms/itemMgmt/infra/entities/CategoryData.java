package com.sms.itemMgmt.infra.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "category")
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryData {
    @Id
    private UUID pk;
    private String name;
    private String status;

    public UUID getPk () {
        return pk;
    }

    public void setPk (UUID pk) {
        this.pk = pk;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }
}
