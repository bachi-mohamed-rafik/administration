package com.banking.admin_module.controller;

import com.banking.admin_module.entity.BGroup;
import com.banking.admin_module.service.BGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business-groups")
public class BGroupController {

    private final BGroupService bGroupService;

    public BGroupController(BGroupService bGroupService) {
        this.bGroupService = bGroupService;
    }

    // Get all business groups
    @GetMapping
    public ResponseEntity<List<BGroup>> getAllBGroups() {
        List<BGroup> bGroups = bGroupService.getAllBGroups();
        return ResponseEntity.ok(bGroups);
    }

    // Get business group by id
    @GetMapping("/{id}")
    public ResponseEntity<BGroup> getBGroupById(@PathVariable String id) {
        BGroup bGroup = bGroupService.getBGroupById(id);
        return ResponseEntity.ok(bGroup);
    }

    // Get business group by code
    @GetMapping("/code/{code}")
    public ResponseEntity<BGroup> getBGroupByCode(@PathVariable String code) {
        BGroup bGroup = bGroupService.getBGroupByCode(code);
        return ResponseEntity.ok(bGroup);
    }

    // Create business group
    @PostMapping
    public ResponseEntity<BGroup> createBGroup(@RequestBody BGroup bGroup) {
        BGroup savedBGroup = bGroupService.createBGroup(bGroup);
        return new ResponseEntity<>(savedBGroup, HttpStatus.CREATED);
    }

    // Update business group
    @PutMapping("/{id}")
    public ResponseEntity<BGroup> updateBGroup(@PathVariable String id, @RequestBody BGroup bGroupDetails) {
        BGroup updatedBGroup = bGroupService.updateBGroup(id, bGroupDetails);
        return ResponseEntity.ok(updatedBGroup);
    }

    // Delete business group
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBGroup(@PathVariable String id) {
        bGroupService.deleteBGroup(id);
        return ResponseEntity.noContent().build();
    }
}
