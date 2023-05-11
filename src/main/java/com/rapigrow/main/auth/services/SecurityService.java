package com.rapigrow.main.auth.services;

import com.google.firebase.auth.FirebaseAuthException;

public interface SecurityService {
    String generateTokenForUser(String userEmailOrUid) throws FirebaseAuthException;
}
