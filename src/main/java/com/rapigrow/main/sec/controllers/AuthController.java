package com.rapigrow.main.sec.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rapigrow.main.sec.dto.UserRequestDTO;
import com.rapigrow.main.sec.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth")
public class AuthController {
    @Autowired
    private ObjectMapper objectMapper;

    //@RequestMapping(value = "/add",method = RequestMethod.GET)
    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @PostMapping("/user")

    public ResponseEntity<UserResponseDTO> userDetails(@RequestBody UserRequestDTO body) throws JsonProcessingException {

//        String parseBody = objectMapper.writeValueAsString(body);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setConfidentialInformation(body.getUserName());
//        System.out.println(parseBody);
//         return ResponseEntity.status(202).body(userResponseDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Ok");
    }


}


//{"userName":"test","abb":"test1","userName1":"test2"}
//{"userName":"test","password":null}