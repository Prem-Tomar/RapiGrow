package com.rapigrow.main.bluecollar.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class JobProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pId;
    private String pName;

    @Id
    private String pUsername;
    private String pPassword;
    private long pMobile;
    private String pEmail;
//    private long location;
     private long pAadhar;
//     private String timeSlot;
     private String serviceNameYouWant;
      private int minPayYouCanOffer;
       private boolean isProviderVerified;

       private String jobProviderSignupDate;

       private String serviceTime;
       private String serviceDate;




}
