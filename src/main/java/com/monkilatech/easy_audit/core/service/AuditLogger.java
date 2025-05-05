package com.monkilatech.easy_audit.core.service;

import com.monkilatech.easy_audit.core.model.AuditEvent;

public interface AuditLogger {
    void log(AuditEvent event);
}
