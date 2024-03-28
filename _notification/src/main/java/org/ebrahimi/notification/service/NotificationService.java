package org.ebrahimi.notification.service;

import org.ebrahimi.notification.NotificationRequest;
import org.ebrahimi.notification.entity.Notification;
import org.ebrahimi.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void sendNotification(NotificationRequest notificationRequest) {
        this.notificationRepository.save(Notification.builder()
                .message(notificationRequest.getMessage() + " With Id:" + notificationRequest.getToProductId())
                .sendAt(LocalDateTime.now())
                .sender("org.ebrahimi")
                .build());
    }

}
