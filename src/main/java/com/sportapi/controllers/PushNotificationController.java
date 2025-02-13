package com.sportapi.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportapi.model.PushNotificationRequest;
import com.sportapi.model.PushNotificationResponse;
import com.sportapi.services.PushNotificationService;

@RestController
@RequestMapping("/notification")
public class PushNotificationController {

    private final PushNotificationService pushNotificationService;

    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }

    @PostMapping("/topic")
    public ResponseEntity<?> sendNotification(@RequestBody PushNotificationRequest request) throws IOException {
        pushNotificationService.sendPushNotificationWithoutData(request);
        return ResponseEntity.ok(new PushNotificationResponse(200, "Notification sent to topic successfully."));
    }

    @PostMapping("/token")
    public ResponseEntity<?> sendTokenNotification(@RequestBody PushNotificationRequest request) throws IOException {
        pushNotificationService.sendPushNotificationToToken(request);
        return ResponseEntity.ok(new PushNotificationResponse(200, "Notification sent to specific device token."));
    }

    @PostMapping("/data")
    public ResponseEntity<?> sendDataNotification(@RequestBody PushNotificationRequest request) throws IOException {
        pushNotificationService.sendPushNotification(request);
        return ResponseEntity.ok(new PushNotificationResponse(200, "Notification with data sent successfully."));
    }
}
