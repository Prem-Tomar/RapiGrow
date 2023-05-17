package com.rapigrow.main.bluecollar.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sId;
    private String sName;
    @Id
    private String sUsername;
    private String sPassword;
    private long sMobile;
    private String sEmail;
    //    private long location;
    private long sAadhar;
    //     private String timeSlot;
    private String sServiceNametoProvide;
    private int minPaySeekerWant;
    private boolean isSeekerVerified;

    private int perHourRatesBySeeker;

    private String jobSeekerSignupDate;


}
