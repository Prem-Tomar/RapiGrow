package com.rapigrow.main.bluecollar.controllers;

import com.rapigrow.main.bluecollar.entities.JobProvider;
import com.rapigrow.main.bluecollar.service.JobProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobprovider")
public class JobProvideController {

      private JobProviderService jp;
    @PostMapping("/add")
    public void addJobProvider(@RequestBody JobProvider jobProvider){
             JobProvider j1= this.jp.addJobProvider(jobProvider);

    }
    @GetMapping("/check")
    public String check(){
        return "Working";
    }

}
