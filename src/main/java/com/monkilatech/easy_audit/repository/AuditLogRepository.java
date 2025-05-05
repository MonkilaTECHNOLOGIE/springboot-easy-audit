package com.monkilatech.easy_audit.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.monkilatech.easy_audit.model.AuditEvent;

public interface AuditLogRepository extends JpaRepository<AuditEvent, Long> {
}
