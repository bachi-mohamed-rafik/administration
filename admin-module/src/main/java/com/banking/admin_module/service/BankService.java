package com.banking.admin_module.service;
import com.banking.admin_module.model.entity.BfsiGroup;
import com.banking.admin_module.repository.BankRepository;
import com.banking.admin_module.model.entity.Bank;
import com.banking.admin_module.repository.BfsiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankService {

    private final BankRepository bankRepository;
    private final BfsiRepository bfsiRepository;

    public List<Bank> getAllBanks(){
        return bankRepository.findAll();
    }

    public Bank getBankById(Long id){
        log.info("Fetching bank with ID: {}", id);
        return   bankRepository.findBankById(id);
    }

    public Bank createBank(Bank bank, Long bfsiGroupId){
        BfsiGroup bfsiGroup = bfsiRepository.findById(bfsiGroupId)
                .orElseThrow(() ->new RuntimeException("not exising in bfsi"));
        bank.setBfsiGroup(bfsiGroup);
        log.info("Creating bank: {}", bank.getName());
        return bankRepository.save(bank);
    }

    @Transactional // Always use Transactional for updates/deletes
    public Bank updateBank(Long id, Bank updatedBank) {
        return bankRepository.findById(id).map(existingBank -> {

            if (updatedBank.getName() != null) existingBank.setName(updatedBank.getName());
            if (updatedBank.getCode() != null) existingBank.setCode(updatedBank.getCode());
            if (updatedBank.getDescription() != null) existingBank.setDescription(updatedBank.getDescription());
            if (updatedBank.getCountryId() != null) existingBank.setCountryId(updatedBank.getCountryId());
            if (updatedBank.getCurrencyId() != null) existingBank.setCurrencyId(updatedBank.getCurrencyId());
            if (updatedBank.getStatus() != null) existingBank.setStatus(updatedBank.getStatus());

            if (updatedBank.getBfsiGroup() != null) {
                existingBank.setBfsiGroup(updatedBank.getBfsiGroup());
            }

            return bankRepository.save(existingBank);
        }).orElseThrow(() -> new RuntimeException("Bank with ID " + id + " not found"));
    }

    public void deleteBank(Long id){
        if (!bankRepository.existsById(id)){
            throw new RuntimeException("id dont exist");
        }
        log.info("Deleting bank with ID: {}", id);
        bankRepository.deleteById(id);
    }

}
