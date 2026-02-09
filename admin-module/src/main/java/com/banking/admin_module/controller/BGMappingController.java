package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.BGMapping;
import com.banking.admin_module.service.BGMappingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/bg-mappings")
@RequiredArgsConstructor
@Tag(name = "Business Group Mapping Management", description = "Operations for managing Business Group Mappings")
public class BGMappingController {

    private final BGMappingService bgMappingService;

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