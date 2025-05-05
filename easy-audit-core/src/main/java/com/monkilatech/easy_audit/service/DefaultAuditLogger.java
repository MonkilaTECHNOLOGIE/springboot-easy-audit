package com.easyaudit.easy_audit.service;

import com.easyaudit.core.model.AuditEvent;
import org.springframework.stereotype.Service;

@Service
public class DefaultAuditLogger implements AuditLogger {

    @Override
    public void log(AuditEvent event) {
        System.out.println("[AUDIT] " + event.getAction() +
            " by " + event.getUsername() +
            " on " + event.getEntity());
    }
}
