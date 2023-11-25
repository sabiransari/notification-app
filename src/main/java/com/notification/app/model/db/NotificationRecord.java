package com.notification.app.model.db;

import com.notification.app.model.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class NotificationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    private String target;
    private String message;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime createdAt;
}
