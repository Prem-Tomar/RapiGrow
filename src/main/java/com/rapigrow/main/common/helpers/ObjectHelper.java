package com.rapigrow.main.common.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

public class ObjectHelper {

    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
}
