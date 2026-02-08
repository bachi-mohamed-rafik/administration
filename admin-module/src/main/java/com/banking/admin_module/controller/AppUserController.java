package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.AppUser;
import com.banking.admin_module.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping
    public ResponseEntity<List<AppUser>> getAllUsers() {
        return ResponseEntity.ok(appUserService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(appUserService.getUserById(id));
    }

    @GetMapping("/login/{loginName}")
    public ResponseEntity<AppUser> getUserByLoginName(@PathVariable String loginName) {
        return ResponseEntity.ok(appUserService.getUserByLoginName(loginName));
    }

    @GetMapping("/active")
    public ResponseEntity<List<AppUser>> getActiveUsers() {
        return ResponseEntity.ok(appUserService.getActiveUsers());
    }

    @PostMapping
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser user) {
        return new ResponseEntity<>(appUserService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser> updateUser(@PathVariable String id, @RequestBody AppUser details) {
        return ResponseEntity.ok(appUserService.updateUser(id, details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        appUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/soft-delete")
    public ResponseEntity<Void> softDeleteUser(@PathVariable String id) {
        appUserService.softDeleteUser(id);
        return ResponseEntity.noContent().build();
    }
}