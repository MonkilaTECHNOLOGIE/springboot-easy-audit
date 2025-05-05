package com.monkilatech.easy_audit.core.model;

import java.time.LocalDateTime;
import java.util.Map;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String entity;
    private String action;
    private String username;
    private LocalDateTime timestamp;
    private Map<String, Object> changes;
}
