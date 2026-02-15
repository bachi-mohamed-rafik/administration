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

public interface BankService {

    public List<BankResponse> getAllBanks();

    public BankResponse getBankById(Long id);

    // create bank
    public BankResponse createBank(CreateBankRequest request);

    @Transactional
    public BankResponse updateBank(Long id, UpdateBankRequest updatedBank);

    public void deleteBank(Long id);


}
