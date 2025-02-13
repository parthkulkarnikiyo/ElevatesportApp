package com.sportapi.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.sportapi.model.PushNotificationRequest;

@Service
public class PushNotificationService {

    private static final String FCM_URL = "https://fcm.googleapis.com/v1/projects/sportsapp-5af73/messages:send";
    private static String accessToken;
    private static Date tokenExpiration;

    private String getAccessToken() throws IOException {
        if (accessToken == null || tokenExpiration == null || new Date().after(tokenExpiration)) {
            InputStream serviceAccountStream = new ClassPathResource("firebase-service-account.json").getInputStream();
            GoogleCredentials googleCredentials = GoogleCredentials
                    .fromStream(serviceAccountStream)
                    .createScoped(Collections.singleton("https://www.googleapis.com/auth/firebase.messaging"));
            googleCredentials.refreshIfExpired();
            AccessToken token = googleCredentials.getAccessToken();
            accessToken = token.getTokenValue();
            tokenExpiration = token.getExpirationTime();
        }
        return accessToken;
    }

    private void sendNotification(Map<String, Object> message) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + getAccessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(message, headers);
        ResponseEntity<String> response = restTemplate.exchange(FCM_URL, HttpMethod.POST, request, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("✅ Notification sent successfully!");
        } else {
            System.out.println("❌ Error sending notification: " + response.getBody());
        }
    }

    public void sendPushNotification(PushNotificationRequest request) throws IOException {
        Map<String, Object> message = buildMessageWithData(request);
        sendNotification(message);
    }

    public void sendPushNotificationWithoutData(PushNotificationRequest request) throws IOException {
        Map<String, Object> message = buildMessageWithoutData(request);
        sendNotification(message);
    }

    public void sendPushNotificationToToken(PushNotificationRequest request) throws IOException {
        Map<String, Object> message = buildMessageToToken(request);
        sendNotification(message);
    }

    private Map<String, Object> buildMessageWithData(PushNotificationRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("messageId", "msgid");
        data.put("text", "Sample data message");
        data.put("user", "User123");

        Map<String, Object> message = new HashMap<>();
        message.put("token", request.getToken());
        message.put("notification", Map.of(
                "title", request.getTitle(),
                "body", request.getMessage()
        ));
        message.put("data", data);

        return Map.of("message", message);
    }

    private Map<String, Object> buildMessageWithoutData(PushNotificationRequest request) {
        Map<String, Object> message = new HashMap<>();
        message.put("topic", request.getTopic());
        message.put("notification", Map.of(
                "title", request.getTitle(),
                "body", request.getMessage()
        ));

        return Map.of("message", message);
    }

    private Map<String, Object> buildMessageToToken(PushNotificationRequest request) {
        Map<String, Object> message = new HashMap<>();
        message.put("token", request.getToken());
        message.put("notification", Map.of(
                "title", request.getTitle(),
                "body", request.getMessage()
        ));

        return Map.of("message", message);
    }
}
