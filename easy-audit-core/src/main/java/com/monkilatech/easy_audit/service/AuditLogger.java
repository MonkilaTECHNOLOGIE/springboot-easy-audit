package com.easyaudit.easy_audit.service;

import com.easyaudit.core.model.AuditEvent;

public interface AuditLogger {
    void log(AuditEvent event);
}
