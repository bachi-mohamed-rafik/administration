package com.banking.admin_module.controller;

import com.banking.admin_module.model.dto.Country.request.CreateCountryRequest;
import com.banking.admin_module.model.dto.Country.request.UpdateCountryRequest;
import com.banking.admin_module.model.dto.Country.response.CountryResponse;
import com.banking.admin_module.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/Country")
@RequiredArgsConstructor
@Tag(name = "Countries", description = "Operations for managing application countries")
public class CountryController {
    private final CountryService countryService;

    //get all countries
    @GetMapping("/allCountries")
    @Operation(
            summary = "Get all Countries",
            description = "Retrieve a list of all Countries in the system.",
            tags = {"Countries"}
    )
    public ResponseEntity<List<CountryResponse>> getAllCountries(){
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    //get country By id
    @GetMapping("/{id}")
    @Operation(
            summary = "Get Country by ID",
            description = "Retrieve a specific Country by its unique ID.",
            tags = {"Countries"}
    )
    public ResponseEntity<CountryResponse> getCountryById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }
    // create Country
    @PostMapping
    @Operation(
            summary = "Create a new Country",
            description = "Add a new Country to the system.",
            tags = {"Countries"}
    )
    public ResponseEntity<CountryResponse> createCountry(
            @RequestBody CreateCountryRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(countryService.createCountry(request));
    }

    //update Country
    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing Country",
            description = "Modify the details of an existing Country identified by its ID.",
            tags = {"Countries"}
    )
    public ResponseEntity<CountryResponse> updateCountry(@PathVariable Long id, @RequestBody UpdateCountryRequest request){
        return ResponseEntity.ok(countryService.updateCountry(id, request));
    }

    //delete Country
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a Country",
            description = "Remove a Country from the system using its unique ID.",
            tags = {"Countries"}
    )
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

}

