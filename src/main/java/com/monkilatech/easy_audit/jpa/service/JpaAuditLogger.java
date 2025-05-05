package com.monkilatech.easy_audit.jpa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monkilatech.easy_audit.jpa.model.AuditJpaEntity;
import com.monkilatech.easy_audit.jpa.repository.AuditLogRepository;


import org.springframework.beans.factory.annotation.Autowired;

public class JpaAuditLogger implements AuditLogger {

    @Autowired
    private AuditLogRepository repository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void log(AuditJpaEntity event) {
        try {
            AuditJpaEntity log = new AuditJpaEntity();
            log.setEntity(event.getEntity());
            log.setAction(event.getAction());
            log.setUsername(event.getUsername());
            log.setTimestamp(event.getTimestamp());
            log.setData(objectMapper.writeValueAsString(event.getChanges()));
            repository.save(log);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
