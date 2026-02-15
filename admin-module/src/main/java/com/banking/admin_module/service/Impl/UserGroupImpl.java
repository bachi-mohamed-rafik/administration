package com.banking.admin_module.service.Impl;

import com.banking.admin_module.mapper.UserGroupMapper;
import com.banking.admin_module.model.dto.UserGroup.response.UserGroupResponse;
import com.banking.admin_module.model.dto.UserGroup.request.CreateUserGroupRequest;
import com.banking.admin_module.model.dto.UserGroup.request.UpdateUserGroupRequest;
import com.banking.admin_module.model.entity.UserGroup;
import com.banking.admin_module.repository.PermissionRepository;
import com.banking.admin_module.service.UserGroupService;
import com.banking.admin_module.repository.UserGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserGroupImpl implements UserGroupService {

    private final UserGroupRepository userGroupRepository;
    private final UserGroupMapper mapper;

    public List<UserGroupResponse> getAllUserGroups() {
        log.debug("Fetching all user groups");
        return userGroupRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public UserGroup getUserGroupById(String id) {
        log.debug("Fetching user group with id: {}", id);
        return userGroupRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("UserGroup not found with id: {}", id);
                    return new RuntimeException("UserGroup not found with id: " + id);
                });
    }

    public List<UserGroup> getUserGroupsByUserId(String userId) {
        log.debug("Fetching user groups for user id: {}", userId);
        return userGroupRepository.findByUserId(userId);
    }

    public UserGroup createUserGroup(UserGroup userGroup) {
        log.debug("Creating new user group for user id: {} and group id: {}", userGroup.getUser().getId(), userGroup.getGroup().getId());
        return userGroupRepository.save(userGroup);
    }

    public UserGroup updateUserGroup(String id, UserGroup details) {
        UserGroup userGroup = getUserGroupById(id);
        userGroup.setUser(details.getUser());
        userGroup.setGroup(details.getGroup());
        userGroup.setPersisted(details.getPersisted());
        userGroup.setAssignedDate(details.getAssignedDate());
        userGroup.setStatus(details.getStatus());
        log.debug("Updating user group with id: {}", id);
        return userGroupRepository.save(userGroup);
    }

    public void deleteUserGroup(String id) {
        UserGroup userGroup = getUserGroupById(id);
        log.debug("Deleting user group with id: {}", id);
        userGroupRepository.delete(userGroup);
    }

}
