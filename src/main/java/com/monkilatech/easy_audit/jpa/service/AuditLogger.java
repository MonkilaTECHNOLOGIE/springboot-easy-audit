package com.monkilatech.easy_audit.jpa.service;

import com.monkilatech.easy_audit.jpa.model.AuditJpaEntity;

public interface AuditLogger {
    void log(AuditJpaEntity event);
}
