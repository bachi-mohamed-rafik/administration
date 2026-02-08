package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.UserGroup;
import com.banking.admin_module.service.UserGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-groups")
@RequiredArgsConstructor
public class UserGroupController {

    private final UserGroupService userGroupService;

    @GetMapping
    public ResponseEntity<List<UserGroup>> getAllUserGroups() {
        return ResponseEntity.ok(userGroupService.getAllUserGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGroup> getUserGroupById(@PathVariable String id) {
        return ResponseEntity.ok(userGroupService.getUserGroupById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserGroup>> getUserGroupsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(userGroupService.getUserGroupsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<UserGroup> createUserGroup(@RequestBody UserGroup userGroup) {
        return new ResponseEntity<>(userGroupService.createUserGroup(userGroup), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserGroup> updateUserGroup(@PathVariable String id, @RequestBody UserGroup details) {
        return ResponseEntity.ok(userGroupService.updateUserGroup(id, details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserGroup(@PathVariable String id) {
        userGroupService.deleteUserGroup(id);
        return ResponseEntity.noContent().build();
    }
}
