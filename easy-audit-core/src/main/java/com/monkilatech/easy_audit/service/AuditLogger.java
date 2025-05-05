package com.easyaudit.easy_audit.service;

import com.easyaudit.easy_audit.model.AuditEvent;

public interface AuditLogger {
    void log(AuditEvent event);
}
