package com.rapigrow.main.users.controllers;

import com.rapigrow.main.users.dto.SampleUserDto;
import com.rapigrow.main.users.entities.SampleUser;
import com.rapigrow.main.users.service.SampleUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sampleuser")
public class SampleUserController {
    SampleUserService sampleUserService;

    @PostMapping("/create")
    public ResponseEntity<SampleUser> saveSampleUser(@RequestBody SampleUserDto sampleUserDto) {
        SampleUser sampleUser = DtoToSampleUser(sampleUserDto);
        SampleUser sampleUser1 = sampleUserService.insert(sampleUser);
        return ResponseEntity.ok(sampleUser1);
    }

    //  We can also use model mapper to deduce below conversions
    public SampleUserDto sampleUserToDto(SampleUser sampleUser) {
        SampleUserDto sampleUserDto = new SampleUserDto();
        sampleUser.setCity(sampleUserDto.getCity());
        sampleUser.setName(sampleUserDto.getName());
        return sampleUserDto;
    }

    public SampleUser DtoToSampleUser(SampleUserDto sampleUserDto) {
        SampleUser sampleUser = new SampleUser();
        sampleUserDto.setCity(sampleUser.getCity());
        sampleUserDto.setName(sampleUser.getName());
        return sampleUser;
    }

}
