package com.rapigrow.main.users.service;

import com.rapigrow.main.users.entities.SampleUser;
import com.rapigrow.main.users.repositry.SampleUserRepo;
import org.springframework.stereotype.Service;

@Service
public class SampleUserServiceImpl implements SampleUserService{

    SampleUserRepo sampleUserRepo;
    @Override
    public SampleUser insert(SampleUser sampleUser) {
        return sampleUserRepo.save(sampleUser);
    }
}
