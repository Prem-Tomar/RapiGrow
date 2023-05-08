package com.rapigrow.main.common.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariConfig {


    @Bean
    public HikariDataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).password("Vishu@894").url("jdbc:mysql://localhost:3306/premproject_api").username("root").build();
    }


}
