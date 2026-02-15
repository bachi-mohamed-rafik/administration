package com.banking.admin_module.controller;

import com.banking.admin_module.model.dto.BfsiGroup.response.BfsiGroupResponse;
import com.banking.admin_module.model.entity.BfsiGroup;
import com.banking.admin_module.repository.BfsiRepository;
import com.banking.admin_module.service.BfsiGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/bfsiGroupApi")
@RequiredArgsConstructor
@Tag(name = "Bfsi Group Management", description = "Operations for managing application bfsi group")
public class BfsiGroupController {
    private final BfsiRepository bfsiRepository;
    private final BfsiGroupService bfsiGroupService;

    // get all bfsgroups
    @Operation(
            summary = "Get all BFSI Groups",
            description = "Retrieve a list of all BFSI groups in the system.",
            tags = {"BFSI Group Management"}
    )
    @GetMapping("/allBfsiGroups")
    public ResponseEntity<List<BfsiGroupResponse>> getAllBfsigroups() {
        List<BfsiGroupResponse> bfsigroups = bfsiGroupService.getAllBfsiGroups();
        if (bfsigroups.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bfsigroups);
    }

    // get one bfsiGroupId by id
    @GetMapping("/{id}")
    @Operation(
            summary = "Get BFSI Group by ID",
            description = "Retrieve a specific BFSI group by its unique identifier.",
            tags = {"BFSI Group Management"}
    )
    public ResponseEntity<BfsiGroup> getBfsiGroupById(@PathVariable Long id) {
        BfsiGroup foundBfsiGroup = bfsiGroupService.getBfsiGroupById(id);
        if (foundBfsiGroup != null) {
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(foundBfsiGroup);
    }

    // create bfsiGroupId
    @PostMapping
    @Operation(
            summary = "Create a new BFSI Group",
            description = "Add a new BFSI group to the system with the provided details.",
            tags = {"BFSI Group Management"}
    )
    public ResponseEntity<BfsiGroup> createBfsiGroup(@RequestBody BfsiGroup newBfsiGroup) {
        BfsiGroup savedBfsiGroup = bfsiGroupService.createBfsiGroup(newBfsiGroup);
        return new ResponseEntity<>(savedBfsiGroup, HttpStatus.CREATED);
    }

    //update a bfsi group
    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing BFSI Group",
            description = "Modify the details of an existing BFSI group identified by its ID.",
            tags = {"BFSI Group Management"}
    )
    public ResponseEntity<BfsiGroup> updateBfsiGroup(@PathVariable Long id, @RequestBody BfsiGroup bfsiGroupDetails){
        BfsiGroup updatedBfsiGroup = bfsiGroupService.updateBfsiGroup(id, bfsiGroupDetails);
        return  new ResponseEntity<>(updatedBfsiGroup, HttpStatus.OK);
    }

    // delete a bfsiGroupId
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a BFSI Group",
            description = "Remove an existing BFSI group from the system using its unique identifier.",
            tags = {"BFSI Group Management"}
    )
    public ResponseEntity<Void> deleteBfsiGroup(@PathVariable Long id){
        bfsiGroupService.deleteBfsiGroup(id);
        return ResponseEntity.noContent().build();
    }




}
