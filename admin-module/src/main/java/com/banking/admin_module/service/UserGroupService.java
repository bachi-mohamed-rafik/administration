package com.banking.admin_module.service;

import com.banking.admin_module.entity.UserGroup;
import com.banking.admin_module.repository.UserGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupService {

    private final UserGroupRepository userGroupRepository;

    public UserGroupService(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    public List<UserGroup> getAllUserGroups() {
        return userGroupRepository.findAll();
    }

    public UserGroup getUserGroupById(String id) {
        return userGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserGroup not found with id: " + id));
    }

    public List<UserGroup> getUserGroupsByUserId(String userId) {
        return userGroupRepository.findByUserId(userId);
    }

    public UserGroup createUserGroup(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    public UserGroup updateUserGroup(String id, UserGroup details) {
        UserGroup userGroup = getUserGroupById(id);
        userGroup.setUser(details.getUser());
        userGroup.setGroup(details.getGroup());
        userGroup.setPersisted(details.getPersisted());
        userGroup.setAssignedDate(details.getAssignedDate());
        userGroup.setStatus(details.getStatus());
        return userGroupRepository.save(userGroup);
    }

    public void deleteUserGroup(String id) {
        UserGroup userGroup = getUserGroupById(id);
        userGroupRepository.delete(userGroup);
    }
}