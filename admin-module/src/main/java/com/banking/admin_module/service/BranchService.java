package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.Branch;
import com.banking.admin_module.repository.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    private final BranchRepository branchRepository;
    //Constructor injection
    public BranchService(BranchRepository branchRepository){
        this.branchRepository= branchRepository;
    }

    // get all branches
    public List<Branch> getAllBranches(){
        return branchRepository.findAll();
    }

    // get branches by id
    public Branch getBranchesById(Long id){
        return branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id not found"));
    }

    // create branch
    public Branch createBranch( Branch branch){
        return branchRepository.save(branch);
    }

    //update Branch
    public Branch updateBranch(Long id, Branch updatedBranch){

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

        return branchRepository.save(existingBranch) ;
    }

    // delete bfsi Group
    public void deleteBranch(Long id){
        if (!branchRepository.existsById(id)){
            throw new RuntimeException("this bfsi dont exixts");
        }
        branchRepository.deleteById(id);
    }

}
