package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.AppUser;
import com.banking.admin_module.service.AppUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/users")
@RequiredArgsConstructor
@Tag(name = "User Management", description = "Operations for managing application users")
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping
    @Operation(
            summary = "Get All Users",
            description = "Retrieve a list of all users in the system"
    )
    public ResponseEntity<List<AppUser>> getAllUsers() {
        return ResponseEntity.ok(appUserService.getAllUsers());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get User by ID",
            description = "Retrieve a user by their unique ID")
    public ResponseEntity<AppUser> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(appUserService.getUserById(id));
    }

    @GetMapping("/login/{loginName}")
    @Operation(
            summary = "Get User by Login Name",
            description = "Retrieve a user by their unique login name")
    public ResponseEntity<AppUser> getUserByLoginName(@PathVariable String loginName) {
        return ResponseEntity.ok(appUserService.getUserByLoginName(loginName));
    }

    @GetMapping("/active")
    @Operation(
            summary = "Get Active Users",
            description = "Retrieve a list of all active users in the system")
    public ResponseEntity<List<AppUser>> getActiveUsers() {
        return ResponseEntity.ok(appUserService.getActiveUsers());
    }

    @PostMapping
    @Operation(
            summary = "Create New User",
            description = "Create a new user in the system with the provided details")
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser user) {
        return new ResponseEntity<>(appUserService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update User",
            description = "Update an existing user's details by their unique ID")
    public ResponseEntity<AppUser> updateUser(@PathVariable String id, @RequestBody AppUser details) {
        return ResponseEntity.ok(appUserService.updateUser(id, details));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete User",
            description = "Permanently delete a user from the system by their unique ID"
    )
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        appUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/soft-delete")
    @Operation(
            summary = "Soft Delete User",
            description = "Soft delete a user by marking them as inactive without removing their data from the system"
    )
    public ResponseEntity<Void> softDeleteUser(@PathVariable String id) {
        appUserService.softDeleteUser(id);
        return ResponseEntity.noContent().build();
    }
}