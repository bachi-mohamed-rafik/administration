package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.Country;
import com.banking.admin_module.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Country")
public class CountryController {
    private final CountryService CountryService;

    // Country controller
    public CountryController(CountryService countryService) {
        this.CountryService = countryService;
    }

    //get all countries
    @GetMapping("/allCountries")
    public ResponseEntity<List<Country>> getAllCountries(){
        List<Country> Countries= CountryService.getAllCountries();
        return ResponseEntity.ok(Countries);
    }

    //get country By id
    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Country Country = CountryService.getCountryById(id);
        if (Country == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(Country);
    }
    // create Country
    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country newCountry){
        Country savedCountry = CountryService.createCountry(newCountry);
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

    //update Country
    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country CountryDetails){
        Country updatedCountry = CountryService.updateCountry(id, CountryDetails);
        return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
    }

    //delete Country
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

}

