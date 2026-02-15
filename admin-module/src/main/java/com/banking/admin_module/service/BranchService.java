package com.banking.admin_module.service;

import com.banking.admin_module.model.dto.Branch.response.BranchResponse;
import com.banking.admin_module.model.entity.Branch;
import com.banking.admin_module.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BranchService {

    // get all branches
    public List<BranchResponse> getAllBranches();

    // get branches by id
    public Branch getBranchesById(Long id);

    // create branch
    public Branch createBranch( Branch branch);

    //update Branch
    public Branch updateBranch(Long id, Branch updatedBranch);

    // delete bfsi Group
    public void deleteBranch(Long id);
}


