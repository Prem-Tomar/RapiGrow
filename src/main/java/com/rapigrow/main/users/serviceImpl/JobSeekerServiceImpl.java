package com.rapigrow.main.users.serviceImpl;

import com.rapigrow.main.users.entities.JobSeeker;
import com.rapigrow.main.users.service.JobSeekerService;

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
            if (e.getId() == sId) {

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
                   js.setEmail(newEmail);
    }

    @Override
    public void updateMobile(JobSeeker js, long newMobile) {
     js.setMobile(newMobile);
    }

    @Override
    public void updatePassword(JobSeeker js, String newPassword) {
         js.setPassword(newPassword);
    }

    @Override
    public void changeTimmings(JobSeeker js,String date, String time) {
            js.setIdealserviceDate(date);
            js.setIdealServiceTime(time);
    }

    @Override
    public void addAadhar(JobSeeker jobseeker, long aadhar) {
       jobseeker.setAadhar(aadhar);
    }
}
