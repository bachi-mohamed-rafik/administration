package com.banking.admin_module.service;

import com.banking.admin_module.model.dto.BGroup.response.BGroupResponse;
import com.banking.admin_module.model.entity.BGroup;
import com.banking.admin_module.repository.BGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BGroupService {

    // Get all business groups
    public List<BGroupResponse> getAllBGroups();

    // Get business group by id
    public BGroup getBGroupById(String id);

    // Get business group by code
    public BGroup getBGroupByCode(String code);

    // Create business group
    public BGroup createBGroup(BGroup bGroup);

    // Update business group
    public BGroup updateBGroup(String id, BGroup bGroupDetails);

    // Delete business group
    public void deleteBGroup(String id);

}