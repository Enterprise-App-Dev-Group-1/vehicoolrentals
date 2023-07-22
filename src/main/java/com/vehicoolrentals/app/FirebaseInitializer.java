package com.vehicoolrentals.app;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseInitializer {

    @PostConstruct
    public void initialize() throws IOException {
        ClassPathResource serviceAccountResource = new ClassPathResource("firebase-adminsdk.json");
        FileInputStream serviceAccount = new FileInputStream(serviceAccountResource.getFile());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://vehicool-rentals.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }
}