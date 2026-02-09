package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.Country;
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
    private final CountryService CountryService;

    //get all countries
    @GetMapping("/allCountries")
    @Operation(
            summary = "Get all Countries",
            description = "Retrieve a list of all Countries in the system.",
            tags = {"Countries"}
    )
    public ResponseEntity<List<Country>> getAllCountries(){
        List<Country> Countries= CountryService.getAllCountries();
        return ResponseEntity.ok(Countries);
    }

    //get country By id
    @GetMapping("/{id}")
    @Operation(
            summary = "Get Country by ID",
            description = "Retrieve a specific Country by its unique ID.",
            tags = {"Countries"}
    )
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Country Country = CountryService.getCountryById(id);
        if (Country == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(Country);
    }
    // create Country
    @PostMapping
    @Operation(
            summary = "Create a new Country",
            description = "Add a new Country to the system.",
            tags = {"Countries"}
    )
    public ResponseEntity<Country> createCountry(@RequestBody Country newCountry){
        Country savedCountry = CountryService.createCountry(newCountry);
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

    //update Country
    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing Country",
            description = "Modify the details of an existing Country identified by its ID.",
            tags = {"Countries"}
    )
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country CountryDetails){
        Country updatedCountry = CountryService.updateCountry(id, CountryDetails);
        return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
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

