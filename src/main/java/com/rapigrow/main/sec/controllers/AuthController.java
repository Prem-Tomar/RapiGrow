package com.rapigrow.main.sec.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuthException;
import com.rapigrow.main.sec.dto.UserRequestDTO;
import com.rapigrow.main.sec.dto.UserResponseDTO;
import com.rapigrow.main.sec.services.SecurityService;
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
        userResponseDTO.setConfidentialInformation(body.getUserName());
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("login")
    public ResponseEntity<String> login() throws FirebaseAuthException {
        return ResponseEntity.ok(service.generateTokenForUser("prem.tomar.gwl@gmail.com"));
    }

}