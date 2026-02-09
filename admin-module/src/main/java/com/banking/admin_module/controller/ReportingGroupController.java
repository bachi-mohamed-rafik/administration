package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.ReportingGroup;
import com.banking.admin_module.service.ReportingGroupService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/reporting-groups")
@RequiredArgsConstructor
@Tag(name = "Reporting Group Management", description = "Operations for managing Reporting Groups")
public class ReportingGroupController {

    private final ReportingGroupService reportingGroupService;

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