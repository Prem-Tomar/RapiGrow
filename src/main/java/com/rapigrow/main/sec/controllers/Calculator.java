package com.rapigrow.main.sec.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "calulatefunction")
public class Calculator {

    @GetMapping("/multiply")
    public int mul(@RequestParam int a, @RequestParam int b){
        return a*b;
    }

//    @PostMapping("post")
//    public int multi(@RequestParam int a, @RequestParam int b){
//        return a*b;
//    }

@GetMapping("fire")
public String check(){
        return "this is check";
}


    @GetMapping("/Sub")
    public int sub(@RequestParam int a, @RequestParam int b){
        return a-b;
    }

    @GetMapping("/div")
    public String divide(@RequestParam int a, @RequestParam int b){

        if(b!=0){
            float ans=a/b;
            String s=String.valueOf(ans);
            return s;
        }
        else{
            return "Can Not Divide By Zero";
        }
    }




}
