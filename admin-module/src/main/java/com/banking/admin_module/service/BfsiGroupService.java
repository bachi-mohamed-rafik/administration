package com.banking.admin_module.service;

import com.banking.admin_module.model.dto.BfsiGroup.response.BfsiGroupResponse;
import com.banking.admin_module.model.entity.BfsiGroup;
import com.banking.admin_module.repository.BfsiRepository;
import com.banking.admin_module.mapper.BfsiGroupMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public interface BfsiGroupService {

    // get all bfsiGroupId
     List<BfsiGroupResponse> getAllBfsiGroups();

    // get bfsiGroupId by id
    public BfsiGroup getBfsiGroupById(Long id);

    // create bfsi group
    public BfsiGroup createBfsiGroup( BfsiGroup bfsiGroup);

    //update bfsiGroupId
    public BfsiGroup updateBfsiGroup(Long id, BfsiGroup updatedBfsiGroup);

    // delete bfsi Group
    public void deleteBfsiGroup(Long id);

}
