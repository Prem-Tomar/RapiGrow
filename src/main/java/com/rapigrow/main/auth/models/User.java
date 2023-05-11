package com.rapigrow.main.auth.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String uid;
    private String email;
    private String issuer;
    private boolean emailVerified;
    private String name;
    private String picture;
}
