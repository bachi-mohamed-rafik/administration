package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.Permission;
import com.banking.admin_module.service.Impl.PermissionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/permissions")
@RequiredArgsConstructor
@Tag(name = "Permission Management", description = "Operations for managing Permissions")
public class PermissionController {

    private final PermissionServiceImpl permissionService;

    @GetMapping
    @Operation(
            summary = "Get All Permissions",
            description = "Retrieve a list of all permissions in the system.",
            tags = {"Permission Management"}
    )
    public ResponseEntity<List<Permission>> getAllPermissions() {
        return ResponseEntity.ok(permissionService.getAllPermissions());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get Permission by ID",
            description = "Retrieve a specific permission by its unique identifier.",
            tags = {"Permission Management"}
    )
    public ResponseEntity<Permission> getPermissionById(@PathVariable String id) {
        return ResponseEntity.ok(permissionService.getPermissionById(id));
    }

    @GetMapping("/group/{groupId}")
    @Operation(
            summary = "Get Permissions by Group ID",
            description = "Retrieve all permissions associated with a specific group.",
            tags = {"Permission Management"}
    )
    public ResponseEntity<List<Permission>> getPermissionsByGroupId(@PathVariable String groupId) {
        return ResponseEntity.ok(permissionService.getPermissionsByGroupId(groupId));
    }

    @PostMapping
    @Operation(
            summary = "Create a New Permission",
            description = "Create a new permission with the provided details.",
            tags = {"Permission Management"}
    )
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        return new ResponseEntity<>(permissionService.createPermission(permission), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update an Existing Permission",
            description = "Update the details of an existing permission identified by its ID.",
            tags = {"Permission Management"}
    )
    public ResponseEntity<Permission> updatePermission(@PathVariable String id, @RequestBody Permission details) {
        return ResponseEntity.ok(permissionService.updatePermission(id, details));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a Permission",
            description = "Delete a permission from the system using its unique identifier.",
            tags = {"Permission Management"}
    )
    public ResponseEntity<Void> deletePermission(@PathVariable String id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}