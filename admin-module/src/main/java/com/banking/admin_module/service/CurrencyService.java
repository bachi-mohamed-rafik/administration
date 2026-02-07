package com.banking.admin_module.service;

import com.banking.admin_module.entity.Currency;
import com.banking.admin_module.repository.CurrencyRepository;
import org.apache.tomcat.util.net.openssl.OpenSSLStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.tomcat.util.net.openssl.OpenSSLStatus.setName;
@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    //Constructor Injection
    public CurrencyService(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }

    // get all currencies
    public List<Currency> getAllCurrencies(){
        return currencyRepository.findAll();
    }

    // get currency by id
    public Currency getCurrencyById(Long id){
        Currency foundCurrency;
                return currencyRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("hhh"));
    }

    // create Currency
    public Currency createCurrency(Currency currency){
        return currencyRepository.save(currency);
    }

    //update a currency
    public Currency updateCurrency(Long id, Currency updatedCurrency){
        Currency existingCurrency = currencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id dont exist"));

        if (updatedCurrency.getName() != null){
            existingCurrency.setName(updatedCurrency.getName());
        }

        if (updatedCurrency.getCode() !=null){
            existingCurrency.setCode(updatedCurrency.getCode());
        }

        if (updatedCurrency.getSymbol() != null){
            existingCurrency.setSymbol(updatedCurrency.getSymbol());
        }
        return currencyRepository.save(existingCurrency);
    }

    //delete a currency
    public void deleteCurrency(Long id){
        if (!currencyRepository.existsById(id)){
            throw new RuntimeException("id deleted");
        }
        currencyRepository.deleteById(id);
    }

}
