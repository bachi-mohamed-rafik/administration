package com.banking.admin_module.controller;

import com.banking.admin_module.model.dto.BfsiGroup.request.CreateBfsiGroupRequest;
import com.banking.admin_module.model.dto.BfsiGroup.request.UpdateBfsiGroupRequest;
import com.banking.admin_module.model.dto.BfsiGroup.response.BfsiGroupResponse;
import com.banking.admin_module.model.dto.globalApiResponse.GlobalApiResponse;
import com.banking.admin_module.service.BfsiGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/bfsiGroupApi")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Bfsi Group Management", description = "Operations for managing BFSI groups")
public class BfsiGroupController {

    private final BfsiGroupService bfsiGroupService; // ✅ Only service, no repository!

    // ✅ Get all bfsi groups
    @GetMapping("/allBfsiGroups")
    @Operation(
            summary = "Get all BFSI Groups",
            description = "Retrieve a list of all BFSI groups in the system."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "BFSI groups récupérés avec succès")
    })
    public ResponseEntity<GlobalApiResponse<List<BfsiGroupResponse>>> getAllBfsiGroups() {
        List<BfsiGroupResponse> result = bfsiGroupService.getAllBfsiGroups();
        return ResponseEntity.ok(GlobalApiResponse.success(result));
    }

    // ✅ Get bfsi group by id
    @GetMapping("/by-id")
    @Operation(
            summary = "Get BFSI Group by ID",
            description = "Retrieve a specific BFSI group by its unique identifier."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "BFSI group récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "BFSI group non trouvé")
    })
    public ResponseEntity<GlobalApiResponse<BfsiGroupResponse>> getBfsiGroupById(
            @Parameter(description = "ID du groupe BFSI", required = true)
            @RequestParam Long id) {

        BfsiGroupResponse result = bfsiGroupService.getBfsiGroupById(id);
        return ResponseEntity.ok(GlobalApiResponse.success(result));
    }

    // ✅ Create bfsi group
    @PostMapping("/create")
    @Operation(
            summary = "Create a new BFSI Group",
            description = "Add a new BFSI group to the system."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "BFSI group créé avec succès")
    })
    public ResponseEntity<GlobalApiResponse<BfsiGroupResponse>> create(
            @Parameter(description = "Données du groupe BFSI")
            @RequestBody @Valid CreateBfsiGroupRequest request) {

        BfsiGroupResponse result = bfsiGroupService.createBfsiGroup(request);
        return ResponseEntity.ok(GlobalApiResponse.success(result));
    }

    // ✅ Update bfsi group
    @PutMapping("/update")
    @Operation(
            summary = "Update an existing BFSI Group",
            description = "Modify the details of an existing BFSI group."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "BFSI group mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "BFSI group non trouvé")
    })
    public ResponseEntity<GlobalApiResponse<BfsiGroupResponse>> updateBfsiGroup(
            @Parameter(description = "ID du groupe BFSI", required = true)
            @RequestParam Long id,
            @Parameter(description = "Données de mise à jour")
            @RequestBody @Valid UpdateBfsiGroupRequest request) {

        BfsiGroupResponse result = bfsiGroupService.updateBfsiGroup(id, request);
        return ResponseEntity.ok(GlobalApiResponse.success(result));
    }

    // ✅ Delete bfsi group
    @DeleteMapping("/delete")
    @Operation(
            summary = "Delete a BFSI Group",
            description = "Remove an existing BFSI group by its unique identifier."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "BFSI group supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "BFSI group non trouvé")
    })
    public ResponseEntity<GlobalApiResponse<Void>> deleteBfsiGroup(
            @Parameter(description = "ID du groupe BFSI", required = true)
            @RequestParam Long id) {

        bfsiGroupService.deleteBfsiGroup(id);
        return ResponseEntity.ok(GlobalApiResponse.deleted());
    }
}