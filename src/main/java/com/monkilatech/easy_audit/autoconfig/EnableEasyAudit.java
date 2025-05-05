package com.monkilatech.easy_audit.autoconfig;

import org.springframework.context.annotation.Import;

import com.monkilatech.easy_audit.config.AuditConfig;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AuditConfig.class)
public @interface EnableEasyAudit {
}
