package com.rapigrow.main.users.entities;

import com.rapigrow.main.users.common.Base;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Feedback extends Base {

     private String feedback;

}
