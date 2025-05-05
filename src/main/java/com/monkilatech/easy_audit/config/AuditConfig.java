package com.monkilatech.easy_audit.config;

import com.monkilatech.easy_audit.service.AuditLogger;
import com.monkilatech.easy_audit.service.DefaultAuditLogger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuditConfig {

    @Bean
    public AuditLogger auditLogger() {
        return new DefaultAuditLogger();
    }
}
