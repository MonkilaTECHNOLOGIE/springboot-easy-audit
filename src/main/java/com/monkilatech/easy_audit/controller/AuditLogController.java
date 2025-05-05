package com.monkilatech.easy_audit.controller;


import org.springframework.web.bind.annotation.*;

import com.monkilatech.easy_audit.model.AuditEvent;
import com.monkilatech.easy_audit.repository.AuditLogRepository;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditLogController {

    private final AuditLogRepository repository;

    public AuditLogController(AuditLogRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<AuditEvent> getAllLogs() {
        return repository.findAll();
    }
}
