package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.Permission;
import com.banking.admin_module.service.PermissionService;
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

    private final PermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermissions() {
        return ResponseEntity.ok(permissionService.getAllPermissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable String id) {
        return ResponseEntity.ok(permissionService.getPermissionById(id));
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<Permission>> getPermissionsByGroupId(@PathVariable String groupId) {
        return ResponseEntity.ok(permissionService.getPermissionsByGroupId(groupId));
    }

    @PostMapping
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        return new ResponseEntity<>(permissionService.createPermission(permission), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable String id, @RequestBody Permission details) {
        return ResponseEntity.ok(permissionService.updatePermission(id, details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable String id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}