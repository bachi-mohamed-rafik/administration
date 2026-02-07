package com.banking.admin_module.controller;

import com.banking.admin_module.entity.ReportingGroup;
import com.banking.admin_module.service.ReportingGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporting-groups")
public class ReportingGroupController {

    private final ReportingGroupService reportingGroupService;

    public ReportingGroupController(ReportingGroupService reportingGroupService) {
        this.reportingGroupService = reportingGroupService;
    }

    @GetMapping
    public ResponseEntity<List<ReportingGroup>> getAllReportingGroups() {
        return ResponseEntity.ok(reportingGroupService.getAllReportingGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportingGroup> getReportingGroupById(@PathVariable String id) {
        return ResponseEntity.ok(reportingGroupService.getReportingGroupById(id));
    }

    @PostMapping
    public ResponseEntity<ReportingGroup> createReportingGroup(@RequestBody ReportingGroup reportingGroup) {
        return new ResponseEntity<>(reportingGroupService.createReportingGroup(reportingGroup), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportingGroup> updateReportingGroup(@PathVariable String id, @RequestBody ReportingGroup details) {
        return ResponseEntity.ok(reportingGroupService.updateReportingGroup(id, details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReportingGroup(@PathVariable String id) {
        reportingGroupService.deleteReportingGroup(id);
        return ResponseEntity.noContent().build();
    }
}