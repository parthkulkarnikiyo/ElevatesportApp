// //package com.sportapi.config;
// //
// //import java.io.IOException;
// //
// //import jakarta.annotation.PostConstruct;
// //
// //import org.slf4j.Logger;
// //import org.slf4j.LoggerFactory;
// //import org.springframework.beans.factory.annotation.Value;
// //import org.springframework.core.io.ClassPathResource;
// //import org.springframework.stereotype.Service;
// //
// //import com.google.auth.oauth2.GoogleCredentials;
// //import com.google.firebase.FirebaseApp;
// //import com.google.firebase.FirebaseOptions;
// //
// //@Service
// //public class FCMInitializer {
// //
// //    @Value("${app.firebase-configuration-file}")
// //    private String firebaseConfigPath;
// //
// //    Logger logger = LoggerFactory.getLogger(FCMInitializer.class);
// //
// //    @PostConstruct
// //    public void initialize() {
// //        try {
// //            FirebaseOptions options = new FirebaseOptions.Builder()
// //                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(firebaseConfigPath).getInputStream())).build();
// //            if (FirebaseApp.getApps().isEmpty()) {
// //                FirebaseApp.initializeApp(options);
// //                logger.info("Firebase application has been initialized");
// //            }
// //        } catch (IOException e) {
// //            logger.error(e.getMessage());
// //        }
// //    }
// //
// //}
// package com.sportapi.config;

// import java.io.IOException;
// import java.io.InputStream;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.core.io.ClassPathResource;
// import org.springframework.stereotype.Service;

// import com.google.auth.oauth2.GoogleCredentials;
// import com.google.firebase.FirebaseApp;
// import com.google.firebase.FirebaseOptions;

// import jakarta.annotation.PostConstruct;

// @Service
// public class FCMInitializer {

//     @Value("${app.firebase-configuration-file}")
//     private String firebaseConfigPath;

//     private static final Logger logger = LoggerFactory.getLogger(FCMInitializer.class);

//     @PostConstruct
//     public void initialize() {
//         try {
//             // Load Firebase config file
//             InputStream serviceAccount = new ClassPathResource(firebaseConfigPath).getInputStream();

//             FirebaseOptions options = FirebaseOptions.builder()
//                     .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                     .build();

//             // Initialize Firebase only if it hasn't been initialized
//             if (FirebaseApp.getApps().isEmpty()) {
//                 FirebaseApp.initializeApp(options);
//                 logger.info("✅ Firebase application has been initialized successfully.");
//             } else {
//                 logger.warn("⚠️ Firebase application already initialized.");
//             }
//         } catch (IOException e) {
//             logger.error("❌ Error initializing Firebase: {}", e.getMessage(), e);
//         }
//     }
// }


package com.sportapi.config;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

import jakarta.annotation.PostConstruct;

@Service
public class FCMInitializer {

    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPath;

    @Value("${app.firebase-database-url}")  // 🔹 Add database URL in application.properties
    private String firebaseDatabaseUrl;

    private static final Logger logger = LoggerFactory.getLogger(FCMInitializer.class);

    @PostConstruct
    public void initialize() {
        try {
            // Load Firebase config file
            InputStream serviceAccount = new ClassPathResource(firebaseConfigPath).getInputStream();

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(firebaseDatabaseUrl)  // 🔹 Set Firebase Database URL
                    .build();

            // Initialize Firebase only if it hasn't been initialized
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                logger.info("✅ Firebase application has been initialized successfully.");
            } else {
                logger.warn("⚠️ Firebase application already initialized.");
            }

            // 🔹 Ensure Firebase Database is initialized
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            logger.info("✅ Firebase Realtime Database initialized successfully.");

        } catch (IOException e) {
            logger.error("❌ Error initializing Firebase: {}", e.getMessage(), e);
        }
    }
}
