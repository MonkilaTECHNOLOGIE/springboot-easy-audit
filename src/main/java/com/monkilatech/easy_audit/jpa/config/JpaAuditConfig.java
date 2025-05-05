package com.monkilatech.easy_audit.jpa.config;

import com.monkilatech.easy_audit.jpa.service.AuditLogger;
import com.monkilatech.easy_audit.jpa.service.JpaAuditLogger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaAuditConfig {

    @Bean
    public AuditLogger auditLogger() {
        return new JpaAuditLogger();
    }
}
