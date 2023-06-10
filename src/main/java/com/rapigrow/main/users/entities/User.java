package com.rapigrow.main.users.entities;

import com.rapigrow.main.users.models.Location;
import com.rapigrow.main.users.common.Base;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends Base {

    private String Name;
    private String Username;
    private String Password;
    private long Mobile;
    private String Email;
    private long Aadhar;
    private Location location;


}