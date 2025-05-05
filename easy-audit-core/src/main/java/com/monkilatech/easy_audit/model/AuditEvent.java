package com.easyaudit.easy_audit.model;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditEvent {
    private String entity;
    private String action;
    private String username;
    private LocalDateTime timestamp;
    private Map<String, Object> changes;
}
