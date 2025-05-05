package com.monkilatech.easy_audit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.monkilatech.easy_audit.core.service.AuditLogger;
import com.monkilatech.easy_audit.core.service.DefaultAuditLogger;

@Configuration
public class AuditConfig {

    @Bean
    public AuditLogger auditLogger() {
        return new DefaultAuditLogger();
    }
}
