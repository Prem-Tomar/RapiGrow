package com.rapigrow.main.users.service;

import com.rapigrow.main.users.entities.JobSeeker;

import java.util.ArrayList;
import java.util.List;

public class JobSeekerServiceImpl implements JobSeekerService {

    List<JobSeeker> slist = new ArrayList<>();

    @Override
    public void addJobSeeker(JobSeeker js) {
        slist.add(js);
    }

    @Override
    public void deleteJobSeeker(long sId) {
        JobSeeker jobseekertobedeleted=null;
        for (JobSeeker e : slist) {
            if (e.getSId() == sId) {

                jobseekertobedeleted = e;
            }
        }
        slist.remove(jobseekertobedeleted);
    }

    @Override
    public void updateHourlyRates(JobSeeker js, int newRates) {
                          js.setPerHourRatesBySeeker(newRates);
    }

    @Override
    public void updateEmail(JobSeeker js, String newEmail) {
                   js.setSEmail(newEmail);
    }

    @Override
    public void updateMobile(JobSeeker js, long newMobile) {
     js.setSMobile(newMobile);
    }

    @Override
    public void updatePassword(JobSeeker js, String newPassword) {
         js.setSPassword(newPassword);
    }

    @Override
    public void changeTimmings(JobSeeker js,String date, String time) {
            js.setIdealserviceDate(date);
            js.setIdealServiceTime(time);
    }

    @Override
    public void addAadhar(JobSeeker jobseeker, long aadhar) {
       jobseeker.setSAadhar(aadhar);
    }
}
