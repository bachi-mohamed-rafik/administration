package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.Branch;
import com.banking.admin_module.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BranchService {

    private final BranchRepository branchRepository;

    // get all branches
    public List<Branch> getAllBranches(){
        log.debug("Fetching all branches");
        return branchRepository.findAll();
    }

    // get branches by id
    public Branch getBranchesById(Long id){
        return branchRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Branch with id {} not found", id);
                    return new RuntimeException("id not found");
                });
    }

    // create branch
    public Branch createBranch( Branch branch){
        log.error("Creating new branch with name: {}", branch.getBranchName());
        return branchRepository.save(branch);
    }

    //update Branch
    public Branch updateBranch(Long id, Branch updatedBranch){
        log.debug("Start updating branch with id: {}", id);
        Branch existingBranch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("this bfsi dont exists!"));

        // modify if there is a modification in name
        if (updatedBranch.getBranchName() != null){
            existingBranch.setBranchName(updatedBranch.getBranchName());
        }

        // modify if there is a modification in code
        if (updatedBranch.getBranchCode() != null){
            existingBranch.setBranchCode(updatedBranch.getBranchCode());
        }

        // modify if there is a modification in description
        if (updatedBranch.getIsMainBranch() != null){
            existingBranch.setIsMainBranch(updatedBranch.getIsMainBranch());
        }

        // modify if there is a modification in name
        if (updatedBranch.getBranchName() != null){
            existingBranch.setBranchName(updatedBranch.getBranchName());
        }

        log.debug("Updating branch with id: {}", id);
        return branchRepository.save(existingBranch) ;
    }

    // delete bfsi Group
    public void deleteBranch(Long id){
        log.info("Start deleting branch with id: {}", id);
        if (!branchRepository.existsById(id)){
            throw new RuntimeException("this bfsi dont exixts");
        }
        log.debug("Deleting branch with id: {}", id);
        branchRepository.deleteById(id);
    }

}
