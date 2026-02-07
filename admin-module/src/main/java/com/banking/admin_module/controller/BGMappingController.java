package com.banking.admin_module.controller;

import com.banking.admin_module.entity.BGMapping;
import com.banking.admin_module.service.BGMappingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bg-mappings")
public class BGMappingController {

    private final BGMappingService bgMappingService;

    public BGMappingController(BGMappingService bgMappingService) {
        this.bgMappingService = bgMappingService;
    }

    // Get all mappings
    @GetMapping
    public ResponseEntity<List<BGMapping>> getAllMappings() {
        List<BGMapping> mappings = bgMappingService.getAllMappings();
        return ResponseEntity.ok(mappings);
    }

    // Get mapping by id
    @GetMapping("/{id}")
    public ResponseEntity<BGMapping> getMappingById(@PathVariable String id) {
        BGMapping mapping = bgMappingService.getMappingById(id);
        return ResponseEntity.ok(mapping);
    }

    // Get mappings by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BGMapping>> getMappingsByUserId(@PathVariable String userId) {
        List<BGMapping> mappings = bgMappingService.getMappingsByUserId(userId);
        return ResponseEntity.ok(mappings);
    }

    // Get mappings by bankId
    @GetMapping("/bank/{bankId}")
    public ResponseEntity<List<BGMapping>> getMappingsByBankId(@PathVariable String bankId) {
        List<BGMapping> mappings = bgMappingService.getMappingsByBankId(bankId);
        return ResponseEntity.ok(mappings);
    }

    // Create mapping
    @PostMapping
    public ResponseEntity<BGMapping> createMapping(@RequestBody BGMapping mapping) {
        BGMapping savedMapping = bgMappingService.createMapping(mapping);
        return new ResponseEntity<>(savedMapping, HttpStatus.CREATED);
    }

    // Update mapping
    @PutMapping("/{id}")
    public ResponseEntity<BGMapping> updateMapping(@PathVariable String id, @RequestBody BGMapping mappingDetails) {
        BGMapping updatedMapping = bgMappingService.updateMapping(id, mappingDetails);
        return ResponseEntity.ok(updatedMapping);
    }

    // Delete mapping
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMapping(@PathVariable String id) {
        bgMappingService.deleteMapping(id);
        return ResponseEntity.noContent().build();
    }
}