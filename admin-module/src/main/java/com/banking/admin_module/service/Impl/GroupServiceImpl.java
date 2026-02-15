package com.banking.admin_module.service.Impl;

import com.banking.admin_module.model.entity.Group;
import com.banking.admin_module.repository.GroupRepository;
import com.banking.admin_module.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        log.debug("Fetching all groups");
        return groupRepository.findAll();
    }

    public Group getGroupById(String id) {
        log.debug("Fetching group with id: {}", id);
        return groupRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Group not found with id: {}", id);
                    return new RuntimeException("Group not found with id: " + id);
                });
    }

    public Group createGroup(Group group) {
        log.debug("Creating new group with code: {}", group.getCode());
        return groupRepository.save(group);
    }

    public Group updateGroup(String id, Group details) {
        Group group = getGroupById(id);
        group.setCode(details.getCode());
        group.setName(details.getName());
        group.setUrl(details.getUrl());
        group.setDescription(details.getDescription());
        log.debug("Updating group with id: {}", id);
        return groupRepository.save(group);
    }

    public void deleteGroup(String id) {
        Group group = getGroupById(id);
        log.debug("Deleting group with id: {}", id);
        groupRepository.delete(group);
    }
}
