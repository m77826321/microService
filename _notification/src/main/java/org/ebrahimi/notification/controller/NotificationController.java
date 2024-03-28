package org.ebrahimi.notification.controller;

import lombok.extern.log4j.Log4j2;
import org.ebrahimi.notification.NotificationRequest;
import org.ebrahimi.notification.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
@Log4j2
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @PostMapping("/send")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("sendNotification: {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }

}
