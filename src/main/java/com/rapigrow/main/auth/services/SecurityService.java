package com.rapigrow.main.auth.services;

import com.google.firebase.auth.FirebaseAuthException;
import com.rapigrow.main.auth.dto.UserRequestDTO;

public interface SecurityService {
    String generateTokenForUser(String userEmailOrUid) throws FirebaseAuthException;

    String createUserOnFireBase(UserRequestDTO body) throws FirebaseAuthException;
}
