package com.banking.admin_module.controller;

import com.banking.admin_module.model.dto.UserGroup.response.UserGroupResponse;
import com.banking.admin_module.model.entity.UserGroup;
import com.banking.admin_module.service.UserGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/user-groups")
@RequiredArgsConstructor
@Tag(name = "User Group Management", description = "Operations for managing User Groups")
public class UserGroupController {

    private final UserGroupService userGroupService;

    @GetMapping
    @Operation(
            summary = "Get All User Groups",
            description = "Retrieve a list of all user groups in the system.",
            tags = {"User Group Management"}
    )
    public ResponseEntity<List<UserGroupResponse>> getAllUserGroups() {
        List<UserGroupResponse> userGroupResponses = userGroupService.getAllUserGroups();
        if (userGroupResponses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userGroupService.getAllUserGroups());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get User Group by ID",
            description = "Retrieve a specific user group by its unique ID.",
            tags = {"User Group Management"}
    )
    public ResponseEntity<UserGroup> getUserGroupById(@PathVariable String id) {
        UserGroup foundUserGroup = userGroupService.getUserGroupById(id);
        if (foundUserGroup == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userGroupService.getUserGroupById(id));
    }

    @GetMapping("/user/{userId}")
    @Operation(
            summary = "Get User Groups by User ID",
            description = "Retrieve all user groups associated with a specific user ID.",
            tags = {"User Group Management"}
    )
    public ResponseEntity<List<UserGroup>> getUserGroupsByUserId(@PathVariable String userId) {
        UserGroup userGroup = userGroupService.getUserGroupsByUserId(userId).stream().findFirst().orElse(null);
        if (userGroup == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userGroupService.getUserGroupsByUserId(userId));
    }

    @PostMapping
    @Operation(
            summary = "Create User Group",
            description = "Create a new user group with the provided details.",
            tags = {"User Group Management"}
    )
    public ResponseEntity<UserGroup> createUserGroup(@RequestBody UserGroup userGroup) {
        return new ResponseEntity<>(userGroupService.createUserGroup(userGroup), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update User Group",
            description = "Update an existing user group with the provided details.",
            tags = {"User Group Management"}
    )
    public ResponseEntity<UserGroup> updateUserGroup(@PathVariable String id, @RequestBody UserGroup details) {
        UserGroup existingUserGroup = userGroupService.getUserGroupById(id);
        if (existingUserGroup == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userGroupService.updateUserGroup(id, details));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete User Group",
            description = "Delete a user group by its unique ID.",
            tags = {"User Group Management"}
    )
    public ResponseEntity<Void> deleteUserGroup(@PathVariable String id) {
        userGroupService.deleteUserGroup(id);
        return ResponseEntity.noContent().build();
    }
}
