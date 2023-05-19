package com.rapigrow.main.users.entities;

import com.rapigrow.main.users.common.Base;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends Base {

    private String Name;
    private String Username;
    private String Password;
    private long Mobile;
    private String Email;
    private long Aadhar;


}
