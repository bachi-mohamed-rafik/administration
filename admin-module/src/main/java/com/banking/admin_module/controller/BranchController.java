package com.banking.admin_module.controller;


import com.banking.admin_module.model.entity.Branch;
import com.banking.admin_module.service.BranchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/branches")
@RequiredArgsConstructor
@Tag(name = "Branches Management", description = "Branches management API")
public class BranchController {

    private final BranchService branchService;

    //get all branches
    @GetMapping("/allBranches")
    @Operation(
            summary = "Get all branches",
            description = "Retrieve a list of all branches"
    )
    public ResponseEntity<List<Branch>> getAllBranches(){
        List<Branch> branches= branchService.getAllBranches();

        if (branches.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(branches);
    }

    //read branch by id
    @GetMapping("/{id}")
    @Operation(
            summary = "Get branch by ID",
            description = "Retrieve a branch by its unique ID"
    )
    public ResponseEntity<Branch> getBankById(@PathVariable Long id){
        if (branchService.getAllBranches().isEmpty()){
            ResponseEntity.noContent().build();
        }
        Branch branch = branchService.getBranchesById(id);
        return ResponseEntity.ok(branch);
    }

    // create a branch
    @PostMapping
    @Operation(
            summary = "Create a new branch",
            description = "Create a new branch with the provided details"
    )
    public ResponseEntity<Branch> createBranch(@RequestBody Branch newBranch){
        Branch savedBranch  = branchService.createBranch(newBranch);
        return new ResponseEntity<>(savedBranch, HttpStatus.CREATED);
    }

    //update a branch
    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing branch",
            description = "Update the details of an existing branch by its ID"
    )
    public ResponseEntity<Branch> updateBranch(@PathVariable Long id, @RequestBody Branch branchDetails){
        Branch savedBranch = branchService.updateBranch(id, branchDetails);
        return  new ResponseEntity<>(savedBranch, HttpStatus.OK);
    }

    // delete a branch
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a branch",
            description = "Delete an existing branch by its ID"
    )
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id){
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }



}
