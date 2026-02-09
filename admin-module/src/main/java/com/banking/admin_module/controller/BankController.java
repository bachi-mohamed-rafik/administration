package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.Bank;
import com.banking.admin_module.service.BankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banking.admin_module.utils.constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/banks")
@RequiredArgsConstructor
@Tag(name = "Bank Management", description = "Operations for managing application banks")
public class BankController {
    private BankService bankService;

    //read all banks controller
    @GetMapping("/allBanks")
    @Operation(
            summary = "Get all banks",
            description = "Retrieve a list of all banks in the system"
    )
    public ResponseEntity<List<Bank>> getAllBanks(){
        List<Bank> banks= bankService.getAllBanks();

        if (banks.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(banks);
    }

    //read bank by id
    @Operation(
            summary = "Get bank by ID",
            description = "Retrieve a specific bank by its unique identifier"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable Long id){
        if (bankService.getAllBanks().isEmpty()){
            ResponseEntity.noContent().build();
        }
        Bank bank = bankService.getBankById(id);
        return ResponseEntity.ok(bank);
    }

    // create a bank1
    @Operation(
            summary = "Create a new bank",
            description = "Add a new bank to the system with the provided details"
    )
    @PostMapping("/bfsiGroup/{bfsiGroupId}")
    public ResponseEntity<Bank> createBank(@RequestBody Bank newBank,
                                           @PathVariable Long bfsiGroupId){
        Bank savedBank = bankService.createBank(newBank, bfsiGroupId)  ;
        return new ResponseEntity<>(savedBank, HttpStatus.CREATED);
    }

    // update a bank
    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing bank",
            description = "Modify the details of an existing bank identified by its ID"
    )
    public ResponseEntity<Bank> updateBank(@PathVariable Long id, @RequestBody Bank bankDetails){
        Bank updatedBank = bankService.updateBank(id, bankDetails);
        return new ResponseEntity<>(updatedBank, HttpStatus.OK);
    }

    // delete bank controller
    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Delete a bank",
            description = "Remove a bank from the system using its unique identifier"
    )
    public ResponseEntity<Void> deleteBank(@PathVariable Long id){
        bankService.deleteBank(id);
        return ResponseEntity.noContent().build();
    }


}
