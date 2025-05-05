package com.monkilatech.easy_audit.jpa.controller;


import org.springframework.web.bind.annotation.*;

import com.monkilatech.easy_audit.jpa.model.AuditJpaEntity;
import com.monkilatech.easy_audit.jpa.repository.AuditLogRepository;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditLogController {

    private final AuditLogRepository repository;

    public AuditLogController(AuditLogRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<AuditJpaEntity> getAllLogs() {
        return repository.findAll();
    }
}
