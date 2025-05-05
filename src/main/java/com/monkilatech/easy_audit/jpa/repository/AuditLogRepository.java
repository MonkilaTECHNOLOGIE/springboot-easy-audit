package com.monkilatech.easy_audit.jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.monkilatech.easy_audit.jpa.model.AuditJpaEntity;

public interface AuditLogRepository extends JpaRepository<AuditJpaEntity, Long> {
}
