package com.monkilatech.easy_audit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monkilatech.easy_audit.model.AuditEvent;
import com.monkilatech.easy_audit.repository.AuditLogRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class JpaAuditLogger implements AuditLogger {

    @Autowired
    private AuditLogRepository repository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void log(AuditEvent event) {
        try {
            AuditEvent log = new AuditEvent();
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
