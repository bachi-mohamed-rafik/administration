package com.banking.admin_module.service;
import com.banking.admin_module.mapper.BankMapper;
import com.banking.admin_module.model.dto.Bank.request.CreateBankRequest;
import com.banking.admin_module.model.dto.Bank.request.UpdateBankRequest;
import com.banking.admin_module.model.dto.Bank.response.BankResponse;
import com.banking.admin_module.model.entity.BfsiGroup;
import com.banking.admin_module.model.entity.Country;
import com.banking.admin_module.model.entity.Currency;
import com.banking.admin_module.repository.BankRepository;
import com.banking.admin_module.model.entity.Bank;
import com.banking.admin_module.repository.BfsiRepository;
import com.banking.admin_module.repository.CountryRepository;
import com.banking.admin_module.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankService {

    private final BankRepository bankRepository;
    private final BfsiRepository bfsiRepository;
    private final CountryRepository countryRepository;
    private final CurrencyRepository currencyRepository;
    private final BankMapper mapper;

    public List<BankResponse> getAllBanks(){
        log.info("Fetching all banks");
        return bankRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public BankResponse getBankById(Long id){
        log.info("Fetching bank with ID: {}", id);
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank with ID " + id + " not found"));
        return   mapper.toResponse(bank);
    }

    // create bank
    public BankResponse createBank(CreateBankRequest request){
        log.info("Creating bank with name: {}", request.name());
        Bank bank = mapper.toEntity(request);
        BfsiGroup bfsiGroup = bfsiRepository.findById(request.bfsiGroupId())
                .orElseThrow(() ->{
                    return new RuntimeException("not exising in bfsi");
                });
        bank.setBfsiGroup(bfsiGroup);
        //set country
        Country country = countryRepository.findById(request.countryId())
                .orElseThrow(() -> new RuntimeException("Country with ID " + request.countryId() + " not found"));
        bank.setCountry(country);
        // set Currency
        Currency currency = currencyRepository.findById(request.currencyId())
                .orElseThrow(() -> new RuntimeException("Currency for Country ID " + request.countryId() + " not found"));
        bank.setCurrency(currency);
        Bank saved= bankRepository.save(bank);
        log.info("Creating bank: {}", bank.getName());
        return mapper.toResponse(saved);
    }

    @Transactional
    public BankResponse updateBank(Long id, UpdateBankRequest updatedBank) {
        log.info("updating bank with ID:{}", id);
        return bankRepository.findById(id).map(existingBank -> {

            if (updatedBank.name() != null) existingBank.setName(updatedBank.name());
            if (updatedBank.code() != null) existingBank.setCode(updatedBank.code());
            if (updatedBank.description() != null) existingBank.setDescription(updatedBank.description());
            if (updatedBank.country() != null) existingBank.setCountry(updatedBank.country());
            if (updatedBank.currency() != null) existingBank.setCurrency(updatedBank.currency());
            if (updatedBank.status() != null) existingBank.setStatus(updatedBank.status());

            if (updatedBank.bfsiGroup() != null) {
                existingBank.setBfsiGroup(updatedBank.bfsiGroup());
            }

            Bank savedBank = bankRepository.save(existingBank);
            return mapper.toResponse(savedBank);
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
