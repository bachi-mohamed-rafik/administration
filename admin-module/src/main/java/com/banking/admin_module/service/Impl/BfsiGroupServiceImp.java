package com.banking.admin_module.service.Impl;

import com.banking.admin_module.mapper.BfsiGroupMapper;
import com.banking.admin_module.model.dto.BfsiGroup.request.CreateBfsiGroupRequest;
import com.banking.admin_module.model.dto.BfsiGroup.request.UpdateBfsiGroupRequest;
import com.banking.admin_module.model.dto.BfsiGroup.response.BfsiGroupResponse;
import com.banking.admin_module.model.entity.BfsiGroup;
import com.banking.admin_module.repository.BfsiRepository;
import com.banking.admin_module.service.BfsiGroupService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BfsiGroupServiceImp implements BfsiGroupService {

    private final BfsiRepository bfsiRepository;
    private final BfsiGroupMapper mapper;

    @Override
    public List<BfsiGroupResponse> getAllBfsiGroups() {
        log.info("Début getAllBfsiGroups - récupération de tous les groupes BFSI");

        List<BfsiGroup> bfsiGroups = bfsiRepository.findAll();

        log.info("getAllBfsiGroups terminé - {} groupes trouvés", bfsiGroups.size());
        return mapper.toResponseList(bfsiGroups);
    }

    @Override
    public BfsiGroupResponse getBfsiGroupById(Long id) {
        log.info("Début getBfsiGroupById - récupération BFSI group id: {}", id);

        BfsiGroup bfsiGroup = bfsiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("BFSI group with ID %d not found", id)
                ));

        log.info("getBfsiGroupById terminé - BFSI group trouvé: {}", bfsiGroup.getName());
        return mapper.toResponse(bfsiGroup);
    }

    @Override
    @Transactional
    public BfsiGroupResponse createBfsiGroup(CreateBfsiGroupRequest request) {
        log.info("Début createBfsiGroup - création BFSI group avec nom: {}", request.name());

        BfsiGroup bfsiGroup = mapper.toEntity(request);
        BfsiGroup savedBfsiGroup = bfsiRepository.save(bfsiGroup);

        log.info("createBfsiGroup terminé - BFSI group créé avec id: {}", savedBfsiGroup.getId());
        return mapper.toResponse(savedBfsiGroup);
    }

    @Override
    @Transactional
    public BfsiGroupResponse updateBfsiGroup(Long id, UpdateBfsiGroupRequest request) {
        log.info("Début updateBfsiGroup - mise à jour BFSI group id: {}", id);

        BfsiGroup bfsiGroup = bfsiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("BFSI group with ID %d not found", id)
                ));

        // Update only non-null fields
        if (request.name() != null) bfsiGroup.setName(request.name());
        if (request.description() != null) bfsiGroup.setDescription(request.description());

        BfsiGroup updatedBfsiGroup = bfsiRepository.save(bfsiGroup);

        log.info("updateBfsiGroup terminé - BFSI group mis à jour id: {}", updatedBfsiGroup.getId());
        return mapper.toResponse(updatedBfsiGroup);
    }

    @Override
    @Transactional
    public void deleteBfsiGroup(Long id) {
        log.info("Début deleteBfsiGroup - suppression BFSI group id: {}", id);

        BfsiGroup bfsiGroup = bfsiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("BFSI group with ID %d not found", id)
                ));

        bfsiRepository.delete(bfsiGroup);

        log.info("deleteBfsiGroup terminé - BFSI group supprimé id: {}", id);
    }
}
