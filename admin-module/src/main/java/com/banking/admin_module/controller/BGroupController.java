package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.BGroup;
import com.banking.admin_module.service.BGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/business-groups")
@RequiredArgsConstructor
@Tag(name = "Business Group Management", description = "Operations for managing application business groups")
public class BGroupController {

    private final BGroupService bGroupService;

    // Get all business groups
    @GetMapping
    @Operation(
            summary = "Get all business groups",
            description = "Retrieve a list of all business groups in the system",
            tags = {"Business Group Management"}
    )
    public ResponseEntity<List<BGroup>> getAllBGroups() {
        List<BGroup> bGroups = bGroupService.getAllBGroups();
        return ResponseEntity.ok(bGroups);
    }

    // Get business group by id
    @GetMapping("/{id}")
    @Operation(
            summary = "Get business group by ID",
            description = "Retrieve a specific business group by its unique identifier",
            tags = {"Business Group Management"}
    )
    public ResponseEntity<BGroup> getBGroupById(@PathVariable String id) {
        BGroup bGroup = bGroupService.getBGroupById(id);
        return ResponseEntity.ok(bGroup);
    }

    // Get business group by code
    @GetMapping("/code/{code}")
    @Operation(
            summary = "Get business group by code",
            description = "Retrieve a specific business group by its unique code",
            tags = {"Business Group Management"}
    )
    public ResponseEntity<BGroup> getBGroupByCode(@PathVariable String code) {
        BGroup bGroup = bGroupService.getBGroupByCode(code);
        return ResponseEntity.ok(bGroup);
    }

    // Create business group
    @PostMapping
    @Operation(
            summary = "Create a new business group",
            description = "Add a new business group to the system with the provided details",
            tags = {"Business Group Management"}
    )
    public ResponseEntity<BGroup> createBGroup(@RequestBody BGroup bGroup) {
        BGroup savedBGroup = bGroupService.createBGroup(bGroup);
        return new ResponseEntity<>(savedBGroup, HttpStatus.CREATED);
    }

    // Update business group
    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing business group",
            description = "Modify the details of an existing business group identified by its ID",
            tags = {"Business Group Management"}
    )
    public ResponseEntity<BGroup> updateBGroup(@PathVariable String id, @RequestBody BGroup bGroupDetails) {
        BGroup updatedBGroup = bGroupService.updateBGroup(id, bGroupDetails);
        return ResponseEntity.ok(updatedBGroup);
    }

    // Delete business group
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a business group",
            description = "Remove a business group from the system using its unique identifier",
            tags = {"Business Group Management"}
    )
    public ResponseEntity<Void> deleteBGroup(@PathVariable String id) {
        bGroupService.deleteBGroup(id);
        return ResponseEntity.noContent().build();
    }
}
