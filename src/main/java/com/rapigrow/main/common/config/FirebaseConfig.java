package com.rapigrow.main.common.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Configuration
public class FirebaseConfig {
    @Bean
    public FirebaseApp firebaseInit() throws IOException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        FirebaseOptions options = null;

        try (InputStream is = classloader.getResourceAsStream("firebase_config.json")) {
            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(Objects.requireNonNull(is)))
                    .build();
        }

        return FirebaseApp.initializeApp(options);

    }
}
