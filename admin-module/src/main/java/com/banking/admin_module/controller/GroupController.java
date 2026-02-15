package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.Group;
import com.banking.admin_module.service.Impl.GroupServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/groups")
@RequiredArgsConstructor
@Tag(name = "Group Management", description = "Operations for managing groups.")
public class GroupController {

    private final GroupServiceImpl groupService;

    @GetMapping
    @Operation(
            summary = "Get All Groups",
            description = "Retrieve a list of all groups.",
            tags = {"Group Management"}
    )
    public ResponseEntity<List<Group>> getAllGroups() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get Group by ID",
            description = "Retrieve a group by its unique ID.",
            tags = {"Group Management"}
    )
    public ResponseEntity<Group> getGroupById(@PathVariable String id) {
        return ResponseEntity.ok(groupService.getGroupById(id));
    }

    @PostMapping
    @Operation(
            summary = "Create New Group",
            description = "Create a new group with the provided details.",
            tags = {"Group Management"}
    )
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        return new ResponseEntity<>(groupService.createGroup(group), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update Existing Group",
            description = "Update the details of an existing group by its ID.",
            tags = {"Group Management"}
    )
    public ResponseEntity<Group> updateGroup(@PathVariable String id, @RequestBody Group details) {
        return ResponseEntity.ok(groupService.updateGroup(id, details));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete Group",
            description = "Delete a group by its unique ID.",
            tags = {"Group Management"}
    )
    public ResponseEntity<Void> deleteGroup(@PathVariable String id) {
        groupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}