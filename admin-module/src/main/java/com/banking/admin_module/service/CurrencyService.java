package com.banking.admin_module.service;

import com.banking.admin_module.mapper.CurrencyMapper;
import com.banking.admin_module.model.dto.Currency.request.CreateCurrencyRequest;
import com.banking.admin_module.model.dto.Currency.request.UpdateCurrencyRequest;
import com.banking.admin_module.model.dto.Currency.response.CurrencyResponse;
import com.banking.admin_module.model.entity.Currency;
import com.banking.admin_module.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public interface CurrencyService {

        // get all currencies
        List<CurrencyResponse> getAllCurrencies();

        // get currency by id
        public CurrencyResponse getCurrencyById(Long id);

        // create Currency
        public CurrencyResponse createCurrency(CreateCurrencyRequest request);

        //update a currency
        public CurrencyResponse updateCurrency(Long id, UpdateCurrencyRequest request);

        //delete a currency
        public void deleteCurrency(Long id);

    }



