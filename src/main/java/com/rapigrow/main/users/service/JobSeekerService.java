package com.rapigrow.main.users.service;

import com.rapigrow.main.users.entities.JobSeeker;


public interface JobSeekerService {

    public void addJobSeeker(JobSeeker js);
    public void deleteJobSeeker(long sId);
    public void updateHourlyRates(JobSeeker js, int newRates);
    public void updateEmail(JobSeeker js, String newEmail);
    public void updateMobile(JobSeeker js, long newMobile);

    public void updatePassword(JobSeeker js, String newPassword);

    public void changeTimmings( JobSeeker js,String date, String time);


    public void addAadhar(JobSeeker jobseeker,long aadhar);

}
