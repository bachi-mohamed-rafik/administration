package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.BfsiGroup;
import com.banking.admin_module.repository.BfsiRepository;
import com.banking.admin_module.service.BfsiGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bfsiGroup")
public class BfsiGroupController {
    private final BfsiRepository bfsiRepository;
    private BfsiGroupService bfsiGroupService;

    // bfsiGroupController constructor
    public BfsiGroupController(BfsiGroupService bfsiGroupService, BfsiRepository bfsiRepository) {
        this.bfsiGroupService = bfsiGroupService;
        this.bfsiRepository = bfsiRepository;
    }

    // get all bfsgroups
    @GetMapping("/allBfsiGroups")
    public ResponseEntity<List<BfsiGroup>> getAllBfsigroups() {
        List<BfsiGroup> bfsigroups = bfsiGroupService.getAllBfsiGroups();

        if (bfsigroups.isEmpty()) {
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bfsigroups);
    }

    // get one bfsiGroup by id
    @GetMapping("/{id}")
    public ResponseEntity<BfsiGroup> getBfsiGroupById(@PathVariable Long id) {
        BfsiGroup foundBfsiGroup = bfsiGroupService.getBfsiGroupById(id);
        if (foundBfsiGroup != null) {
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(foundBfsiGroup);
    }

    // create bfsiGroup
    @PostMapping
    public ResponseEntity<BfsiGroup> createBfsiGroup(@RequestBody BfsiGroup newBfsiGroup) {
        BfsiGroup savedBfsiGroup = bfsiGroupService.createBfsiGroup(newBfsiGroup);
        return new ResponseEntity<>(savedBfsiGroup, HttpStatus.CREATED);
    }

    //update a bfsi group
    @PutMapping("/{id}")
    public ResponseEntity<BfsiGroup> updateBfsiGroup(@PathVariable Long id, @RequestBody BfsiGroup bfsiGroupDetails){
        BfsiGroup updatedBfsiGroup = bfsiGroupService.updateBfsiGroup(id, bfsiGroupDetails);
        return  new ResponseEntity<>(updatedBfsiGroup, HttpStatus.OK);
    }

    // delete a bfsiGroup
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBfsiGroup(@PathVariable Long id){
        bfsiGroupService.deleteBfsiGroup(id);
        return ResponseEntity.noContent().build();
    }




}
