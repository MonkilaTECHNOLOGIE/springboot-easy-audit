package com.easyaudit.core.aspect;

import com.easyaudit.easy_audit.annotation.Auditable;
import com.easyaudit.easy_audit.model.AuditEvent;
import com.easyaudit.easy_audit.service.AuditLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AuditAspect {

    @Autowired
    private AuditLogger auditLogger;

    @AfterReturning(pointcut = "@annotation(auditable)", returning = "result")
    public void logAfter(JoinPoint joinPoint, Auditable auditable, Object result) {
        AuditEvent event = new AuditEvent();
        event.setAction(auditable.value().isEmpty() ? joinPoint.getSignature().getName() : auditable.value());
        event.setEntity(joinPoint.getTarget().getClass().getSimpleName());
        event.setUsername("system"); // To be enhanced via security context
        event.setTimestamp(LocalDateTime.now());
        auditLogger.log(event);
    }
}
