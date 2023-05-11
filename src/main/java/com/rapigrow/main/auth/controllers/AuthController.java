package com.rapigrow.main.auth.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuthException;
import com.rapigrow.main.auth.dto.UserRequestDTO;
import com.rapigrow.main.auth.dto.UserResponseDTO;
import com.rapigrow.main.auth.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth")
public class AuthController {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityService service;

    //@RequestMapping(value = "/add",method = RequestMethod.GET)
    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @PostMapping("/user")

    public ResponseEntity<UserResponseDTO> userDetails(@RequestBody UserRequestDTO body) throws JsonProcessingException {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setConfidentialInformation(body.getUsername());
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("login")
    public ResponseEntity<String> login() throws FirebaseAuthException {
        return ResponseEntity.ok(service.generateTokenForUser("prem.tomar.gwl@gmail.com"));
    }

    @PostMapping("signup")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO body) throws FirebaseAuthException {
        var user = service.createUserOnFireBase(body);
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setConfidentialInformation(user);
        return ResponseEntity.ok(responseDTO);
    }

    // TODO: create signup for user using firebase sdk
    // TODO: save all the information received from creating customer
    // TODO: Keep data normalised for meta information and primary user information
    // TODO: User basic auth to capture user credentials from client
    // TODO: Validate username and password, fetch the UID from database
    // TODO: Use uid to JWT token for user
    // TODO: Change user request and response DTOs to reflect actual user information consumed and produced



}