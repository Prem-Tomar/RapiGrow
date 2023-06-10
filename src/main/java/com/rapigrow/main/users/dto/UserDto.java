package com.rapigrow.main.users.dto;

import com.rapigrow.main.users.models.Location;
import com.rapigrow.main.users.common.Base;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends Base {
    private String Name;
    private String Username;
//    private String Password;
    private long Mobile;
    private String Email;
    private long Aadhar;
    private Location location;

}
