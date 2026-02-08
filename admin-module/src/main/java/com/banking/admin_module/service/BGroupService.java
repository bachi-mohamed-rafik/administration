package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.BGroup;
import com.banking.admin_module.repository.BGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BGroupService {

    private final BGroupRepository bGroupRepository;

    // Get all business groups
    public List<BGroup> getAllBGroups() {
        return bGroupRepository.findAll();
    }

    // Get business group by id
    public BGroup getBGroupById(String id) {
        return bGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business Group not found with id: " + id));
    }

    // Get business group by code
    public BGroup getBGroupByCode(String code) {
        return bGroupRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Business Group not found with code: " + code));
    }

    // Create business group
    public BGroup createBGroup(BGroup bGroup) {
        return bGroupRepository.save(bGroup);
    }

    // Update business group
    public BGroup updateBGroup(String id, BGroup bGroupDetails) {
        BGroup bGroup = getBGroupById(id);

        bGroup.setCode(bGroupDetails.getCode());
        bGroup.setName(bGroupDetails.getName());
        bGroup.setDescription(bGroupDetails.getDescription());

        return bGroupRepository.save(bGroup);
    }

    // Delete business group
    public void deleteBGroup(String id) {
        BGroup bGroup = getBGroupById(id);
        bGroupRepository.delete(bGroup);
    }
}