package com.banking.admin_module.controller;

import com.banking.admin_module.model.dto.Currency.request.CreateCurrencyRequest;
import com.banking.admin_module.model.dto.Currency.request.UpdateCurrencyRequest;
import com.banking.admin_module.model.dto.Currency.response.CurrencyResponse;
import com.banking.admin_module.model.entity.Currency;
import com.banking.admin_module.service.Impl.CurrencyServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/Currency")
@RequiredArgsConstructor
@Tag(name = "Currencies Management", description = "Operations for managing application currencies")
public class CurrencyController {
    private final CurrencyServiceImpl currencyService;

    //get all currnecies
    @GetMapping("/allCurrencies")
    @Operation(
            summary = "Get All Currencies",
            description = "Retrieve a list of all currencies available in the application.",
            tags = {"Currencies Management"}
    )
    public ResponseEntity<List<CurrencyResponse>> getAllCurrencies(){
        return ResponseEntity.ok(currencyService.getAllCurrencies());
    }

    //get Cuurency By id
    @GetMapping("/{id}")
    @Operation(
            summary = "Get Currency by ID",
            description = "Retrieve a specific currency by its unique identifier.",
            tags = {"Currencies Management"}
    )
    public ResponseEntity<CurrencyResponse> getCurrencyById(@PathVariable Long id) {
        return ResponseEntity.ok(currencyService.getCurrencyById(id));
    }
    // create currency
    @PostMapping
    @Operation(
            summary = "Create a New Currency",
            description = "Add a new currency to the application.",
            tags = {"Currencies Management"}
    )
    public ResponseEntity<CurrencyResponse> createCurrency(
            @RequestBody CreateCurrencyRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(currencyService.createCurrency(request));
    }

    //update currency
    @PutMapping("/{id}")
    @Operation(
            summary = "Update an Existing Currency",
            description = "Modify the details of an existing currency identified by its ID.",
            tags = {"Currencies Management"}
    )
    public ResponseEntity<Currency> updateCurrency(@PathVariable Long id, @RequestBody UpdateCurrencyRequest request){
        return ResponseEntity.ok(currencyService.updateCurrency(id, request));
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

