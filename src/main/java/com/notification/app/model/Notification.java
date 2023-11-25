package com.notification.app.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Notification {
    private String source;
    private String target;
    private String message;
    private Status status;
    private LocalDateTime createdAt;
}
