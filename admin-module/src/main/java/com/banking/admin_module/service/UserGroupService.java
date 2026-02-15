package com.banking.admin_module.service;

import com.banking.admin_module.model.dto.UserGroup.response.UserGroupResponse;
import com.banking.admin_module.model.entity.UserGroup;

import java.util.List;

public interface UserGroupService {
    public List<UserGroupResponse> getAllUserGroups();

    public UserGroup getUserGroupById(String id);

    public List<UserGroup> getUserGroupsByUserId(String userId);

    public UserGroup createUserGroup(UserGroup userGroup);

    public UserGroup updateUserGroup(String id, UserGroup details);

    public void deleteUserGroup(String id);

}
