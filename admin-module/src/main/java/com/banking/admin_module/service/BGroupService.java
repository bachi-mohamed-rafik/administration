package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.BGroup;
import com.banking.admin_module.repository.BGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BGroupService {

    private final BGroupRepository bGroupRepository;

    // Get all business groups
    public List<BGroup> getAllBGroups() {
        log.info("Fetching all business groups");
        return bGroupRepository.findAll();
    }

    // Get business group by id
    public BGroup getBGroupById(String id) {
        log.debug("Fetching business group with id: {}", id);
        return bGroupRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Business Group not found with id: {}", id);
                    return new RuntimeException("Business Group not found with id: " + id);
                });
    }

    // Get business group by code
    public BGroup getBGroupByCode(String code) {
        log.debug("Fetching business group with code: {}", code);
        return bGroupRepository.findByCode(code)
                .orElseThrow(() -> {
                    log.error("Business Group not found with code: {}", code);
                     return new RuntimeException("Business Group not found with code: " + code);
                });
    }

    // Create business group
    public BGroup createBGroup(BGroup bGroup) {
        log.debug("Creating business group with code: {}", bGroup.getCode());
        return bGroupRepository.save(bGroup);
    }

    // Update business group
    public BGroup updateBGroup(String id, BGroup bGroupDetails) {
        BGroup bGroup = getBGroupById(id);

        bGroup.setCode(bGroupDetails.getCode());
        bGroup.setName(bGroupDetails.getName());
        bGroup.setDescription(bGroupDetails.getDescription());

        log.debug("Updating business group with id: {}", id);
        return bGroupRepository.save(bGroup);
    }

    // Delete business group
    public void deleteBGroup(String id) {
        BGroup bGroup = getBGroupById(id);
        log.debug("Deleting business group with id: {}", id);
        bGroupRepository.delete(bGroup);
    }
}