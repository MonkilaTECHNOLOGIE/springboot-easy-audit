package com.monkilatech.easy_audit.core.service;

import org.springframework.stereotype.Service;

import com.monkilatech.easy_audit.core.model.AuditEvent;

@Service
public class DefaultAuditLogger implements AuditLogger {

    @Override
    public void log(AuditEvent event) {
        System.out.println("[AUDIT] " + event.getAction() +
            " by " + event.getUsername() +
            " on " + event.getEntity());
    }
}
