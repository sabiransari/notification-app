package com.notification.app.poller;

import com.notification.app.model.Notification;
import com.notification.app.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationReceiver {
    @Autowired
    private NotificationService notificationService;
    @SqsListener(value = "notificationQueue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(final Notification notification, @Header("SenderId") String senderId) {
        log.info("notification received {}, {}", senderId, notification);
        notificationService.saveNotification(notification);
        log.info("notification saved successfully");
    }
}
