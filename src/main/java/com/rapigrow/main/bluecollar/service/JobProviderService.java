package com.rapigrow.main.bluecollar.service;

import com.rapigrow.main.bluecollar.entities.JobProvider;
import com.rapigrow.main.bluecollar.entities.JobSeeker;


public interface JobProviderService {

    public JobProvider addJobProvider(JobProvider jobprovider);

    public void deleteJobProvider(long jId);


    void updateRates(JobProvider jp, int rates);

    public void updateEmail(JobProvider jp, String newEmail);

    public void updateMobile(JobProvider jp, long newMobile);

    public void updatePassword(JobProvider jobprovider, String newPassword);

    public void changeTimmings(JobProvider jp, String date, String time);

    public void checkRatesOfJobSeeker(JobSeeker jobSeeker);

    public void addAadhar(JobProvider jobprovider, long aadhar);

}
