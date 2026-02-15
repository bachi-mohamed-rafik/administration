package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.BGMapping;
import com.banking.admin_module.repository.BGMappingRepository;

import java.util.List;

public interface BGMappingService {

    // Get all mappings
    public List<BGMapping> getAllMappings();

    // Get mapping by id
    public BGMapping getMappingById(String id);

    // Get mappings by userId
    public List<BGMapping> getMappingsByUserId(String userId);

    // Get mappings by bankId
    public List<BGMapping> getMappingsByBankId(String bankId);

    // Create mapping
    public BGMapping createMapping(BGMapping mapping);

    // Update mapping
    public BGMapping updateMapping(String id, BGMapping mappingDetails);

    // Delete mapping
    public void deleteMapping(String id);

}
