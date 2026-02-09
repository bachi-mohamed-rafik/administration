package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.Currency;
import com.banking.admin_module.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/currency")
@RequiredArgsConstructor
@Tag(name = "Currencies Management", description = "Operations for managing application currencies")
public class CurrencyController {
    private final CurrencyService currencyService;

    //get all currnecies
    @GetMapping("/allCurrencies")
    @Operation(
            summary = "Get All Currencies",
            description = "Retrieve a list of all currencies available in the application.",
            tags = {"Currencies Management"}
    )
    public ResponseEntity<List<Currency>> getAllCurrencies(){
        List<Currency> currencies= currencyService.getAllCurrencies();
        return ResponseEntity.ok(currencies);
    }

    //get Cuurency By id
    @GetMapping("/{id}")
    @Operation(
            summary = "Get Currency by ID",
            description = "Retrieve a specific currency by its unique identifier.",
            tags = {"Currencies Management"}
    )
    public ResponseEntity<Currency> getCurrencyById(@PathVariable Long id) {
        Currency currency = currencyService.getCurrencyById(id);
        if (currency == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(currency);
    }
    // create currency
    @PostMapping
    @Operation(
            summary = "Create a New Currency",
            description = "Add a new currency to the application.",
            tags = {"Currencies Management"}
    )
    public ResponseEntity<Currency> createCurrency(@RequestBody Currency newCurrency){
        Currency savedCurrency = currencyService.createCurrency(newCurrency);
        return new ResponseEntity<>(savedCurrency, HttpStatus.CREATED);
    }

    //update currency
    @PutMapping("/{id}")
    @Operation(
            summary = "Update an Existing Currency",
            description = "Modify the details of an existing currency identified by its ID.",
            tags = {"Currencies Management"}
    )
    public ResponseEntity<Currency> updateCurrency(@PathVariable Long id, @RequestBody Currency currencyDetails){
        Currency updatedCurrency = currencyService.updateCurrency(id, currencyDetails);
        return new ResponseEntity<>(updatedCurrency, HttpStatus.OK);
    }

    //delete Currency
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a Currency",
            description = "Remove a currency from the application using its unique identifier.",
            tags = {"Currencies Management"}
    )
    public ResponseEntity<Void> deleteCurrnecy(@PathVariable Long id){
        currencyService.deleteCurrency(id);
        return ResponseEntity.noContent().build();
    }

    }

