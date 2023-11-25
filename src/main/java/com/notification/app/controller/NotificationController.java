package com.notification.app.controller;

import com.notification.app.model.Status;
import com.notification.app.model.db.NotificationRecord;
import com.notification.app.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/notification")
public class NotificationController {
    @Autowired private NotificationService notificationService;

    @GetMapping("/target/{targetId}")
    public ResponseEntity<Page<NotificationRecord>> getNotification(@PathVariable String targetId,
                                                                    @RequestParam(defaultValue = "UNREAD") Status status,
                                                                    @RequestParam(defaultValue = "0") Integer pageNo,
                                                                    @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<NotificationRecord> notificationsByTarget = notificationService.getNotificationsByTarget(targetId, status, PageRequest.of(pageNo, pageSize));
        return ResponseEntity.ok(notificationsByTarget);
    }

    @PatchMapping("/{notificationId}/read")
    public ResponseEntity.BodyBuilder markNotificationRead(@PathVariable Long notificationId) {
        notificationService.markNotificationRead(notificationId);
        return ResponseEntity.ok();
    }
}
