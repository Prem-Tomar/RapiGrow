package com.rapigrow.main.sec.services;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
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
}
