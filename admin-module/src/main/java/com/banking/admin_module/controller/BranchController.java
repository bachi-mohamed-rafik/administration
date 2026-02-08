package com.banking.admin_module.controller;


import com.banking.admin_module.model.entity.Branch;
import com.banking.admin_module.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    //get all branches
    @GetMapping("/allBranches")
    public ResponseEntity<List<Branch>> getAllBranches(){
        List<Branch> branches= branchService.getAllBranches();

        if (branches.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(branches);
    }

    //read branch by id
    @GetMapping("/{id}")
    public ResponseEntity<Branch> getBankById(@PathVariable Long id){
        if (branchService.getAllBranches().isEmpty()){
            ResponseEntity.noContent().build();
        }
        Branch branch = branchService.getBranchesById(id);
        return ResponseEntity.ok(branch);
    }

    // create a branch
    @PostMapping
    public ResponseEntity<Branch> createBranch(@RequestBody Branch newBranch){
        Branch savedBranch  = branchService.createBranch(newBranch);
        return new ResponseEntity<>(savedBranch, HttpStatus.CREATED);
    }

    //update a branch
    @PutMapping("/{id}")
    public ResponseEntity<Branch> updateBranch(@PathVariable Long id, @RequestBody Branch branchDetails){
        Branch savedBranch = branchService.updateBranch(id, branchDetails);
        return  new ResponseEntity<>(savedBranch, HttpStatus.OK);
    }

    // delete a branch
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id){
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }



}
