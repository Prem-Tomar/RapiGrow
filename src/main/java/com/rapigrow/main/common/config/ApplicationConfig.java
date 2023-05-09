package com.rapigrow.main.common.config;

import jakarta.annotation.Nonnull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rapigrow")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ApplicationConfig {

    private DB db;
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    public static class DB {
        @Nonnull
        private String username;
        @Nonnull
        private String password;
        @Nonnull
        private String host;
        @Nonnull
        private String port;
        @Nonnull
        private String name;
        @Nonnull
        private String url;

        private String dialect;
    }
}
