package com.rapigrow.main.users.serviceImpl;

import com.rapigrow.main.users.entities.JobProvider;
import com.rapigrow.main.users.entities.JobSeeker;
import com.rapigrow.main.users.service.JobProviderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobProvideServiceImpl implements JobProviderService {

    List<JobProvider> plist = new ArrayList<>();

    @Override
    public JobProvider addJobProvider(JobProvider jobprovider) {
        plist.add(jobprovider);
        return jobprovider;
    }

    @Override
    public void deleteJobProvider(long pId) {
        JobProvider jp = new JobProvider();
        for (JobProvider e : plist) {
            long x = e.getId();
            if (x == pId) {
                plist.remove(e);
            }
        }
    }

    @Override
    public void updateRates(JobProvider jp, int rates) {
        jp.setMinPayYouCanOffer(rates);
    }

    @Override
    public void updateEmail(JobProvider jp, String newEmail) {
        jp.setEmail(newEmail);
    }

    @Override
    public void updateMobile(JobProvider jp, long newMobile) {
        jp.setMobile(newMobile);
    }

    @Override
    public void updatePassword(JobProvider jobprovider, String newPassword) {
        jobprovider.setPassword(newPassword);
    }

    @Override
    public void changeTimmings(JobProvider jp, String date, String time) {
                  jp.setServiceDate(date);
                  jp.setServiceTime(time);
    }

    @Override
    public void checkRatesOfJobSeeker(JobSeeker jobSeeker) {
               jobSeeker.getPerHourRatesBySeeker();
               jobSeeker.getPerHourRatesBySeeker();
    }

    @Override
    public void addAadhar(JobProvider jobprovider, long aadhar) {
                      jobprovider.setAadhar(aadhar);
    }
}