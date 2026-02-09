package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.BGroup;
import com.banking.admin_module.service.BGroupService;
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
