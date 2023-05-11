package com.rapigrow.main.auth.services;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.rapigrow.main.auth.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {


    @Autowired
   private FirebaseAuth firebaseAuth;

    @Override
    public String generateTokenForUser(String userEmailOrUid) throws FirebaseAuthException {
        return firebaseAuth.createCustomToken(userEmailOrUid);
    }

    @Override
    public String createUserOnFireBase(UserRequestDTO body) throws FirebaseAuthException {
        var createUserRequest = new UserRecord.CreateRequest();
        createUserRequest.setEmail(body.getUsername());
        createUserRequest.setPassword(body.getPassword());
        var result = firebaseAuth.createUser(createUserRequest);
        return result.getUid();
    }
}
