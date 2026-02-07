package com.banking.admin_module.controller;

import com.banking.admin_module.entity.Currency;
import com.banking.admin_module.repository.CurrencyRepository;
import com.banking.admin_module.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    // currency controller
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    //get all currnecies
    @GetMapping("/allCurrencies")
    public ResponseEntity<List<Currency>> getAllCurrencies(){
        List<Currency> currencies= currencyService.getAllCurrencies();
        return ResponseEntity.ok(currencies);
    }

    //get Cuurency By id
    @GetMapping("/{id}")
    public ResponseEntity<Currency> getCurrencyById(@PathVariable Long id) {
        Currency currency = currencyService.getCurrencyById(id);
        if (currency == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(currency);
    }
    // create currency
    @PostMapping
    public ResponseEntity<Currency> createCurrency(@RequestBody Currency newCurrency){
        Currency savedCurrency = currencyService.createCurrency(newCurrency);
        return new ResponseEntity<>(savedCurrency, HttpStatus.CREATED);
    }

    //update currency
    @PutMapping("/{id}")
    public ResponseEntity<Currency> updateCurrency(@PathVariable Long id, @RequestBody Currency currencyDetails){
        Currency updatedCurrency = currencyService.updateCurrency(id, currencyDetails);
        return new ResponseEntity<>(updatedCurrency, HttpStatus.OK);
    }

    //delete Currency
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrnecy(@PathVariable Long id){
        currencyService.deleteCurrency(id);
        return ResponseEntity.noContent().build();
    }

    }

