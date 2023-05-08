package com.rapigrow.main.common.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariConfig {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Bean
    public HikariDataSource dataSource() {
        String URL_SEPARATOR = "/";
        var db = applicationConfig.getDb();
        String dbUrl = db.getUrl() + db.getHost() + ":" + db.getPort() + URL_SEPARATOR + db.getName();
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .password(db.getPassword())
                .username(db.getUsername())
                .url(dbUrl)
                .build();
    }


}
