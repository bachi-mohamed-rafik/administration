package com.banking.admin_module.controller;

import com.banking.admin_module.model.dto.Bank.request.CreateBankRequest;
import com.banking.admin_module.model.dto.Bank.request.UpdateBankRequest;
import com.banking.admin_module.model.dto.Bank.response.BankResponse;
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
@RequestMapping(APP_ROOT+"/bankApi")
@RequiredArgsConstructor
@Tag(name = "Bank Management", description = "Operations for managing application banks")
public class BankController {
    private final BankService bankService;

    //read all banks controller
    @GetMapping("/allBanks")
    @Operation(
            summary = "Get all banks",
            description = "Retrieve a list of all banks in the system"
    )
    public ResponseEntity<List<BankResponse>> getAllBanks(){
        List<BankResponse> banks= bankService.getAllBanks();

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
    public ResponseEntity<BankResponse> getBankById(@PathVariable Long id){
        if (bankService.getAllBanks().isEmpty()){
            ResponseEntity.noContent().build();
        }
        BankResponse bank = bankService.getBankById(id);
        return ResponseEntity.ok(bank);
    }

    // create a bank
    @Operation(
            summary = "Create a new bank",
            description = "Add a new bank to the system with the provided details"
    )
    @PostMapping("/bfsiGroupId/{bfsiGroupId}")
    public ResponseEntity<BankResponse> createBank(
            @RequestBody CreateBankRequest newBankRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bankService.createBank(newBankRequest));
    }

    // update a bank
    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing bank",
            description = "Modify the details of an existing bank identified by its ID"
    )
    public ResponseEntity<BankResponse> updateBank(@PathVariable Long id, @RequestBody UpdateBankRequest bankDetails){
        BankResponse updatedBank = bankService.updateBank(id, bankDetails);
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
