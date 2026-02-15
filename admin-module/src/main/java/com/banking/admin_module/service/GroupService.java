package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.Group;
import com.banking.admin_module.repository.GroupRepository;

import java.util.List;

public interface GroupService {

    public List<Group> getAllGroups();

    public Group getGroupById(String id);

    public Group createGroup(Group group);

    public Group updateGroup(String id, Group details);

    public void deleteGroup(String id);

}
