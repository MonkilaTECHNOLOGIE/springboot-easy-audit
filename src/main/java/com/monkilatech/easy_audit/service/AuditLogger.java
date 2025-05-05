package com.monkilatech.easy_audit.service;

import com.monkilatech.easy_audit.model.AuditEvent;

public interface AuditLogger {
    void log(AuditEvent event);
}
