package com.banking.admin_module.service.Impl;

import com.banking.admin_module.mapper.CurrencyMapper;
import com.banking.admin_module.model.dto.Currency.request.CreateCurrencyRequest;
import com.banking.admin_module.model.dto.Currency.request.UpdateCurrencyRequest;
import com.banking.admin_module.model.dto.Currency.response.CurrencyResponse;
import com.banking.admin_module.model.entity.Currency;
import com.banking.admin_module.repository.CurrencyRepository;
import com.banking.admin_module.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper mapper;

    // get all currencies
    public List<CurrencyResponse> getAllCurrencies(){
        log.debug("Fetching all currencies");
        return currencyRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    // get currency by id
    public CurrencyResponse getCurrencyById(Long id){
        Currency foundCurrency;
        log.debug("Fetching currency with id: {}", id);
        Currency currency= currencyRepository.findById(id)
                .orElseThrow(()-> {
                    log.error("Currency with id {} not found", id);
                    return new RuntimeException("hhh");
                });
        return mapper.toResponse(currency);
    }

    // create Currency
    public CurrencyResponse createCurrency(CreateCurrencyRequest request){
        log.debug("Creating new currency with code: {}", request.name());
        Currency currency = mapper.toEntity(request);
        Currency savedCurrency = currencyRepository.save(currency);

        return mapper.toResponse(savedCurrency);
    }

    //update a currency
    public Currency updateCurrency(Long id, UpdateCurrencyRequest updatedCurrency){
        log.debug("Start updating currency with id: {}", id);
        Currency existingCurrency = currencyRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Currency with id {} not found for update", id);
                    return new RuntimeException("id dont exist");
                });
        if (updatedCurrency.name() != null) {
            existingCurrency.setName(updatedCurrency.name());
        }
        if (updatedCurrency.code() != null) {
            existingCurrency.setCode(updatedCurrency.code());
        }
        Currency updated = currencyRepository.save(existingCurrency);
        log.debug("Finished updating currency with id: {}", id);
        return updated;
    }

    //delete a currency
    public void deleteCurrency(Long id){
        log.debug("Start deleting currency with id: {}", id);
        if (!currencyRepository.existsById(id)){
            log.error("Currency with id {} not found for deletion", id);
            throw new RuntimeException("id deleted");
        }
        log.debug("Finished deleting currency with id: {}", id);
        currencyRepository.deleteById(id);
    }

}
