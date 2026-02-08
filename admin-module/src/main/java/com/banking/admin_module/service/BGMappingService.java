package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.BGMapping;
import com.banking.admin_module.repository.BGMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BGMappingService {

    private final BGMappingRepository bgMappingRepository;

    // Get all mappings
    public List<BGMapping> getAllMappings() {
        return bgMappingRepository.findAll();
    }

    // Get mapping by id
    public BGMapping getMappingById(String id) {
        return bgMappingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mapping not found with id: " + id));
    }

    // Get mappings by userId
    public List<BGMapping> getMappingsByUserId(String userId) {
        return bgMappingRepository.findByUserId(userId);
    }

    // Get mappings by bankId
    public List<BGMapping> getMappingsByBankId(String bankId) {
        return bgMappingRepository.findByBankId(bankId);
    }

    // Create mapping
    public BGMapping createMapping(BGMapping mapping) {
        return bgMappingRepository.save(mapping);
    }

    // Update mapping
    public BGMapping updateMapping(String id, BGMapping mappingDetails) {
        BGMapping mapping = getMappingById(id);

        mapping.setUser(mappingDetails.getUser());
        mapping.setBankId(mappingDetails.getBankId());
        mapping.setBusinessGroup(mappingDetails.getBusinessGroup());
        mapping.setReportingGroup(mappingDetails.getReportingGroup());
        mapping.setGroupId(mappingDetails.getGroupId());
        mapping.setCategoryId(mappingDetails.getCategoryId());

        return bgMappingRepository.save(mapping);
    }

    // Delete mapping
    public void deleteMapping(String id) {
        BGMapping mapping = getMappingById(id);
        bgMappingRepository.delete(mapping);
    }
}