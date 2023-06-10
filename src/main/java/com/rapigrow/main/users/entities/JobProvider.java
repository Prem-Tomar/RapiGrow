package com.rapigrow.main.users.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class JobProvider extends User {

    private String serviceNameYouWant;
    private int minPayYouCanOffer;
    private String serviceTime;
    private String serviceDate;


}
