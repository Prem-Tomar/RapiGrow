package com.rapigrow.main.users.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundExceptions extends RuntimeException{
    String resourceName;
    String fieldName;
    long fieldvalue;
    public ResourceNotFoundExceptions(String resourceName, String fieldName, long fieldvalue) {
        super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldvalue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldvalue = fieldvalue;
    }
}
