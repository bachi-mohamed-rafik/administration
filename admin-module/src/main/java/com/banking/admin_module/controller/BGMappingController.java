package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.BGMapping;
import com.banking.admin_module.service.BGMappingService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(
            summary = "Get all Business Group Mappings",
            description = "Retrieve a list of all Business Group Mappings in the system.",
            tags = {"Business Group Mapping Management"}
    )
    public ResponseEntity<List<BGMapping>> getAllMappings() {
        List<BGMapping> mappings = bgMappingService.getAllMappings();
        return ResponseEntity.ok(mappings);
    }

    // Get mapping by id
    @GetMapping("/{id}")
    @Operation(
            summary = "Get Business Group Mapping by ID",
            description = "Retrieve a specific Business Group Mapping by its unique identifier.",
            tags = {"Business Group Mapping Management"}
    )
    public ResponseEntity<BGMapping> getMappingById(@PathVariable String id) {
        BGMapping mapping = bgMappingService.getMappingById(id);
        return ResponseEntity.ok(mapping);
    }

    // Get mappings by userId
    @GetMapping("/user/{userId}")
    @Operation(
            summary = "Get Business Group Mappings by User ID",
            description = "Retrieve a list of Business Group Mappings associated with a specific user.",
            tags = {"Business Group Mapping Management"}
    )
    public ResponseEntity<List<BGMapping>> getMappingsByUserId(@PathVariable String userId) {
        List<BGMapping> mappings = bgMappingService.getMappingsByUserId(userId);
        return ResponseEntity.ok(mappings);
    }

    // Get mappings by bankId
    @GetMapping("/bank/{bankId}")
    @Operation(
            summary = "Get Business Group Mappings by Bank ID",
            description = "Retrieve a list of Business Group Mappings associated with a specific bank.",
            tags = {"Business Group Mapping Management"}
    )
    public ResponseEntity<List<BGMapping>> getMappingsByBankId(@PathVariable String bankId) {
        List<BGMapping> mappings = bgMappingService.getMappingsByBankId(bankId);
        return ResponseEntity.ok(mappings);
    }

    // Create mapping
    @PostMapping
    @Operation(
            summary = "Create a new Business Group Mapping",
            description = "Create a new Business Group Mapping by providing the necessary details in the request body.",
            tags = {"Business Group Mapping Management"}
    )
    public ResponseEntity<BGMapping> createMapping(@RequestBody BGMapping mapping) {
        BGMapping savedMapping = bgMappingService.createMapping(mapping);
        return new ResponseEntity<>(savedMapping, HttpStatus.CREATED);
    }

    // Update mapping
    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing Business Group Mapping",
            description = "Update the details of an existing Business Group Mapping by providing its ID and the updated information in the request body.",
            tags = {"Business Group Mapping Management"}
    )
    public ResponseEntity<BGMapping> updateMapping(@PathVariable String id, @RequestBody BGMapping mappingDetails) {
        BGMapping updatedMapping = bgMappingService.updateMapping(id, mappingDetails);
        return ResponseEntity.ok(updatedMapping);
    }

    // Delete mapping
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a Business Group Mapping",
            description = "Delete an existing Business Group Mapping by providing its unique identifier.",
            tags = {"Business Group Mapping Management"}
    )
    public ResponseEntity<Void> deleteMapping(@PathVariable String id) {
        bgMappingService.deleteMapping(id);
        return ResponseEntity.noContent().build();
    }
}