package com.rapigrow.main.users.service;

import com.rapigrow.main.users.entities.JobProvider;
import com.rapigrow.main.users.entities.JobSeeker;


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
