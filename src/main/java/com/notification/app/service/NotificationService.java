package com.notification.app.service;

import com.notification.app.model.Notification;
import com.notification.app.model.Status;
import com.notification.app.model.db.NotificationRecord;
import com.notification.app.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
    public void saveNotification(Notification notification) {
    }

    public Page<NotificationRecord> getNotificationsByTarget(String targetId, Status status, PageRequest pageRequest) {
        return notificationRepository.findAll(notificationSpec(targetId, status), pageRequest);
    }

    private Specification<NotificationRecord> notificationSpec(String targetId, Status status) {
        return (r, cq, cb) ->
            cb.and(cb.equal(r.get("target"), targetId), cb.equal(r.get("status"), status));
    }

    public void markNotificationRead(Long notificationId) {
        NotificationRecord notificationRecord = new NotificationRecord();
        notificationRecord.setId(notificationId);
        notificationRecord.setStatus(Status.READ);
        notificationRepository.save(notificationRecord);
        log.info("notification {} marked read", notificationId);
    }
}
