package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.UserGroup;
import com.banking.admin_module.repository.UserGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserGroupService {

    private final UserGroupRepository userGroupRepository;

    public List<UserGroup> getAllUserGroups() {
        log.debug("Fetching all user groups");
        return userGroupRepository.findAll();
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