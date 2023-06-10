package com.rapigrow.main.users.common;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
@Getter
@Setter
public class Base {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean isDeleted;
    private boolean isCreated;
    private boolean isVerified;
    private String creationDate;



}
