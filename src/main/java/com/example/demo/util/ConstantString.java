package com.example.demo.util;


public class ConstantString {

    public static final String ID_EXISTS = "Can not create new #ENTITY with id: #ID. member already exists";
    public static final String ID_NULL = "Can not update #ENTITY with id.null: ";
    public static final String EMAIL_EXISTS = "A #ENTITY already exists with the #EMAIL address: {} ";


    // SERVICE LOGS
    public static final String DELETE_LOG = "Request to delete #ENTITY:  {}";
    public static final String UPDATE_LOG = "Request to update #ENTITY:  {}";
    public static final String SAVE_LOG = "Request to create new #ENTITY:  {}";
    public static final String GET_LOG = "Request to get #ENTITY:  {}";
    public static final String FIND_BY_LOG = "Request to get #ENTITY by #FIELD {}";

    // RESOURCE LOGS
    public static final String REST_DELETE_LOG = "Rest request to delete #ENTITY:  {}";
    public static final String REST_UPDATE_LOG = "Rest request to update #ENTITY:  {}";
    public static final String REST_SAVE_LOG = "Rest request to create new #ENTITY:  {}";
    public static final String REST_GET_LOG = "Rest request to get #ENTITY:  {}";


    //  CONSTANT PACKAGE STRINGS.
    public  static final String SAVING_PACKAGE = "com.njangi.entities.Savings";
    public  static final String MEMBER_PACKAGE = "com.njangi.entities.Member";
    public  static final String ACHIEVEMENT_PACKAGE = "com.njangi.entities.Achievement";
    public  static final String BORN_HOUSE_PACKAGE = "com.njangi.entities.BornHouse";
    public  static final String FUNERAL_PACKAGE = "com.njangi.entities.Funeral";

}