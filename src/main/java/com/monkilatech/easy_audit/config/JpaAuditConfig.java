package com.monkilatech.easy_audit.config;

import com.monkilatech.easy_audit.service.AuditLogger;
import com.monkilatech.easy_audit.service.JpaAuditLogger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaAuditConfig {

    @Bean
    public AuditLogger auditLogger() {
        return new JpaAuditLogger();
    }
}
