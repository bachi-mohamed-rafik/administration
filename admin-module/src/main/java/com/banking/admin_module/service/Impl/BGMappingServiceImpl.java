package com.banking.admin_module.service.Impl;

import com.banking.admin_module.model.entity.BGMapping;
import com.banking.admin_module.repository.BGMappingRepository;
import com.banking.admin_module.service.BGMappingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BGMappingServiceImpl implements BGMappingService {
    private final BGMappingRepository bgMappingRepository;

    // Get all mappings
    @Override
    public List<BGMapping> getAllMappings() {
        return bgMappingRepository.findAll();
    }

    // Get mapping by id
    @Override
    public BGMapping getMappingById(String id) {
        log.info("Fetching BGMapping with id: {}", id);
        return bgMappingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mapping not found with id: " + id));
    }

    // Get mappings by userId
    @Override
    public List<BGMapping> getMappingsByUserId(String userId) {
        log.info(" Fetching BGMappings for userId: {}", userId);
        return bgMappingRepository.findByUserId(userId);
    }

    // Get mappings by bankId
    @Override
    public List<BGMapping> getMappingsByBankId(String bankId) {
        log.info(" Fetching BGMappings for bankId: {}", bankId);
        return bgMappingRepository.findByBankId(bankId);
    }

    // Create mapping
    @Override
    public BGMapping createMapping(BGMapping mapping) {
        log.info(" Creating new BGMapping for user: {} and bank: {}", mapping.getUser().getId(), mapping.getBankId());
        return bgMappingRepository.save(mapping);
    }

    // Update mapping
    @Override
    public BGMapping updateMapping(String id, BGMapping mappingDetails) {
        BGMapping mapping = getMappingById(id);

        mapping.setUser(mappingDetails.getUser());
        mapping.setBankId(mappingDetails.getBankId());
        mapping.setBusinessGroup(mappingDetails.getBusinessGroup());
        mapping.setReportingGroup(mappingDetails.getReportingGroup());
        mapping.setGroupId(mappingDetails.getGroupId());
        mapping.setCategoryId(mappingDetails.getCategoryId());
        log.info(" Updating BGMapping with id: {}", id);
        return bgMappingRepository.save(mapping);
    }

    // Delete mapping
    @Override
    public void deleteMapping(String id) {
        BGMapping mapping = getMappingById(id);
        log.info(" Deleting BGMapping with id: {}", id);
        bgMappingRepository.delete(mapping);
    }
}
