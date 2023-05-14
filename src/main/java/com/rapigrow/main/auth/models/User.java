package com.rapigrow.main.auth.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.context.annotation.RequestScope;

@Getter
@Setter
@ToString
@RequestScope
public class User {
    private String uid;
    private String email;
    private String issuer;
    private boolean emailVerified;
    private String name;
    private String picture;
}
