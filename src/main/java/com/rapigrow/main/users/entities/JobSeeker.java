package com.rapigrow.main.users.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JobSeeker extends User{

    //     private String timeSlot;
    private String sServiceNametoProvide;
    private int minPaySeekerWant;
    private int perHourRatesBySeeker;
    private String idealServiceTime;
    private String idealserviceDate;


}
