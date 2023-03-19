package com.example.demo.listeners;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.io.Serializable;

@Document(value = "entityauditevent")
public class EntityAuditEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field(name = "entityId")
    private String entityId;

    @Field(name = "year")
    private Integer year;

    @Field(name = "entityPackage")
    private String entityPackage;

//    @Lob
    @Field(name = "entityValue")
    private String entityValue;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getEntityValue() {
        return entityValue;
    }

    public void setEntityValue(String entityValue) {
        this.entityValue = entityValue;
    }
}