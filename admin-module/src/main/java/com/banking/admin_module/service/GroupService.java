package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.Group;
import com.banking.admin_module.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(String id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + id));
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group updateGroup(String id, Group details) {
        Group group = getGroupById(id);
        group.setCode(details.getCode());
        group.setName(details.getName());
        group.setUrl(details.getUrl());
        group.setDescription(details.getDescription());
        return groupRepository.save(group);
    }

    public void deleteGroup(String id) {
        Group group = getGroupById(id);
        groupRepository.delete(group);
    }
}