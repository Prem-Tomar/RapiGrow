package com.rapigrow.main.common.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Configuration
public class FirebaseConfig {
    @Bean
    public FirebaseApp firebaseInit() throws IOException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        FirebaseOptions options = null;

        try (InputStream is = classloader.getResourceAsStream("serviceAccountKey.json")) {
            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(Objects.requireNonNull(is)))
                    .build();

//            options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(Objects.requireNonNull(is)))
//                    .setDatabaseUrl("https://rapigrow-21156-default-rtdb.asia-southeast1.firebasedatabase.app")
//                    .build();
        }

        return FirebaseApp.initializeApp(options);

    }

    @Bean
    public FirebaseAuth getFireBaseAuth() throws IOException {
        return FirebaseAuth.getInstance(firebaseInit());
    }
}
