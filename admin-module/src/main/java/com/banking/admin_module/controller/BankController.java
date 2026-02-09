package com.banking.admin_module.controller;

import com.banking.admin_module.model.entity.Bank;
import com.banking.admin_module.service.BankService;
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
    public ResponseEntity<List<Bank>> getAllBanks(){
        List<Bank> banks= bankService.getAllBanks();

        if (banks.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(banks);
    }

    //read bank by id
    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable Long id){
        if (bankService.getAllBanks().isEmpty()){
            ResponseEntity.noContent().build();
        }
        Bank bank = bankService.getBankById(id);
        return ResponseEntity.ok(bank);
    }

    // create a bank1
    @PostMapping("/bfsiGroup/{bfsiGroupId}")
    public ResponseEntity<Bank> createBank(@RequestBody Bank newBank,
                                           @PathVariable Long bfsiGroupId){
        Bank savedBank = bankService.createBank(newBank, bfsiGroupId)  ;
        return new ResponseEntity<>(savedBank, HttpStatus.CREATED);
    }

    // update a bank
    @PutMapping("/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable Long id, @RequestBody Bank bankDetails){
        Bank updatedBank = bankService.updateBank(id, bankDetails);
        return new ResponseEntity<>(updatedBank, HttpStatus.OK);
    }

    // delete bank controller
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long id){
        bankService.deleteBank(id);
        return ResponseEntity.noContent().build();
    }


}
