package com.rapigrow.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@Slf4j
@ComponentScan(basePackages = {"com.rapigrow.main"})
public class MainApplication {
    public static void main(String[] args) {


        ApplicationContext context = SpringApplication.run(MainApplication.class, args);
    }
}
