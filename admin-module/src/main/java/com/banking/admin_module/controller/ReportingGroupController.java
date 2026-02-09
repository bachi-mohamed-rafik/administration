package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.ReportingGroup;
import com.banking.admin_module.service.ReportingGroupService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(
            summary = "Get All Reporting Groups",
            description = "Retrieve a list of all reporting groups in the system.",
            tags = {"Reporting Group Management"}
    )
    public ResponseEntity<List<ReportingGroup>> getAllReportingGroups() {
        return ResponseEntity.ok(reportingGroupService.getAllReportingGroups());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get Reporting Group by ID",
            description = "Retrieve a specific reporting group by its unique identifier.",
            tags = {"Reporting Group Management"}
    )
    public ResponseEntity<ReportingGroup> getReportingGroupById(@PathVariable String id) {
        return ResponseEntity.ok(reportingGroupService.getReportingGroupById(id));
    }

    @PostMapping
    @Operation(
            summary = "Create a New Reporting Group",
            description = "Create a new reporting group with the provided details.",
            tags = {"Reporting Group Management"}
    )
    public ResponseEntity<ReportingGroup> createReportingGroup(@RequestBody ReportingGroup reportingGroup) {
        return new ResponseEntity<>(reportingGroupService.createReportingGroup(reportingGroup), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update an Existing Reporting Group",
            description = "Update the details of an existing reporting group identified by its ID.",
            tags = {"Reporting Group Management"}
    )
    public ResponseEntity<ReportingGroup> updateReportingGroup(@PathVariable String id, @RequestBody ReportingGroup details) {
        return ResponseEntity.ok(reportingGroupService.updateReportingGroup(id, details));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a Reporting Group",
            description = "Delete a reporting group from the system using its unique identifier.",
            tags = {"Reporting Group Management"}
    )
    public ResponseEntity<Void> deleteReportingGroup(@PathVariable String id) {
        reportingGroupService.deleteReportingGroup(id);
        return ResponseEntity.noContent().build();
    }
}