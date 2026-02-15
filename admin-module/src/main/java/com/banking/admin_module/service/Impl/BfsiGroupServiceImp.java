
package com.banking.admin_module.service.Impl;

import com.banking.admin_module.model.dto.BfsiGroup.response.BfsiGroupResponse;
import com.banking.admin_module.model.entity.BfsiGroup;
import com.banking.admin_module.repository.BfsiRepository;
import com.banking.admin_module.mapper.BfsiGroupMapper;
import com.banking.admin_module.service.BfsiGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BfsiGroupServiceImp implements BfsiGroupService {

    private final BfsiRepository bfsiRepository;
    private final BfsiGroupMapper mapper;

    // get all bfsiGroupId
    public List<BfsiGroupResponse> getAllBfsiGroups(){
        log.info("Fetching all BFSI groups");
        return bfsiRepository.findAllWithBanks()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    // get bfsiGroupId by id
    public BfsiGroup getBfsiGroupById(Long id){
        return bfsiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id not found"));
    }

    // create bfsi group
    public BfsiGroup createBfsiGroup( BfsiGroup bfsiGroup){
        log.info(" Creating new BFSI group with name: {}", bfsiGroup.getName());
        return bfsiRepository.save(bfsiGroup);
    }

    //update bfsiGroupId
    public BfsiGroup updateBfsiGroup(Long id, BfsiGroup updatedBfsiGroup){

        BfsiGroup existingBfsiGroup = bfsiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("this bfsi dont exists!"));

        // modify if there is a modification in name
        if (updatedBfsiGroup.getName() != null){
            existingBfsiGroup.setName(updatedBfsiGroup.getName());
        }

        // modify if there is a description
        if (updatedBfsiGroup.getDescription()!= null){
            existingBfsiGroup.setDescription(updatedBfsiGroup.getDescription());
        }
        log.info("Updating BFSI group with id: {}", id);
        return bfsiRepository.save(existingBfsiGroup) ;
    }

    // delete bfsi Group
    public void deleteBfsiGroup(Long id){
        if (!bfsiRepository.existsById(id)){
            throw new RuntimeException("this bfsi dont exixts");
        }
        bfsiRepository.deleteById(id);
    }

}
