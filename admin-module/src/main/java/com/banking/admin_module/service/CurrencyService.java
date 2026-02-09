package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.Currency;
import com.banking.admin_module.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    // get all currencies
    public List<Currency> getAllCurrencies(){
        log.debug("Fetching all currencies");
        return currencyRepository.findAll();
    }

    // get currency by id
    public Currency getCurrencyById(Long id){
        Currency foundCurrency;
        log.debug("Fetching currency with id: {}", id);
                return currencyRepository.findById(id)
                        .orElseThrow(()-> {
                            log.error("Currency with id {} not found", id);
                             return new RuntimeException("hhh");
                        });
    }

    // create Currency
    public Currency createCurrency(Currency currency){
        log.debug("Creating new currency with code: {}", currency.getCode());
        return currencyRepository.save(currency);
    }

    //update a currency
    public Currency updateCurrency(Long id, Currency updatedCurrency){
        log.debug("Start updating currency with id: {}", id);
        Currency existingCurrency = currencyRepository.findById(id)
                .orElseThrow(() -> {
                        log.error("Currency with id {} not found for update", id);
                    return new RuntimeException("id dont exist");
                });

        if (updatedCurrency.getName() != null){
            existingCurrency.setName(updatedCurrency.getName());
        }

        if (updatedCurrency.getCode() !=null){
            existingCurrency.setCode(updatedCurrency.getCode());
        }

        if (updatedCurrency.getSymbol() != null){
            existingCurrency.setSymbol(updatedCurrency.getSymbol());
        }
        log.debug("Finished updating currency with id: {}", id);
        return currencyRepository.save(existingCurrency);
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
