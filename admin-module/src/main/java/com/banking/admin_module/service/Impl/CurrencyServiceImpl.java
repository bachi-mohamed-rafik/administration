package com.banking.admin_module.service.Impl;

import com.banking.admin_module.exception.ResourceAlreadyExistsException;
import com.banking.admin_module.mapper.CurrencyMapper;
import com.banking.admin_module.model.dto.Currency.request.CreateCurrencyRequest;
import com.banking.admin_module.model.dto.Currency.request.UpdateCurrencyRequest;
import com.banking.admin_module.model.dto.Currency.response.CurrencyResponse;
import com.banking.admin_module.model.entity.Currency;
import com.banking.admin_module.repository.CurrencyRepository;
import com.banking.admin_module.service.CurrencyService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    @Override
    public List<CurrencyResponse> getAllCurrencies(){
        log.info("Fetching all currencies");
        List<Currency> currencies= currencyRepository.findAll();

        log.info("Fetched {} currencies", currencies.size());
        return mapper.toResponseList(currencies);
    }

    // get currency by id
    @Override
    public CurrencyResponse getCurrencyById(Long id){
        log.info("Fetching currency with id: {}", id);

        Currency currency= currencyRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(
                        String.format("Currency with id %d not found", id)
                ));
        log.info("Fetched currency: {}", currency.getName());
        return mapper.toResponse(currency);
    }

    // create Currency
    @Override
    @Transactional
    public CurrencyResponse createCurrency(CreateCurrencyRequest request){
        log.debug("Creating new currency with code: {}", request.name());

        if (currencyRepository.existsByCode(request.code())){
            throw new ResourceAlreadyExistsException(
                    String.format("Currency with code %s already exists", request.code())
            );
        }
        Currency currency = mapper.toEntity(request);
        Currency savedCurrency = currencyRepository.save(currency);

        log.info("Created currency with id: {}", savedCurrency.getId());
        return mapper.toResponse(savedCurrency);
    }

    //update a currency
    public CurrencyResponse updateCurrency(Long id, UpdateCurrencyRequest request){
        log.debug("Start updating currency with id: {}", id);

        Currency existingCurrency = currencyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Currency with id %d not found for update", id)
                        ));
        if (request.name() != null) {
            existingCurrency.setName(request.name());
        }
        if (request.code() != null) {
            existingCurrency.setCode(request.code());
        }
        Currency updatedCurrency = currencyRepository.save(existingCurrency);
        CurrencyResponse updatedResponse = mapper.toResponse(updatedCurrency);
        log.debug("Finished updating currency with id: {}", id);
        return updatedResponse;
    }

    //delete a currency
    public void deleteCurrency(Long id){
        log.debug("Start deleting currency with id: {}", id);
        Currency existingCurrency = currencyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Currency with id %d not found for deletion", id)
                ));
        currencyRepository.delete(existingCurrency);
        log.debug("Finished deleting currency with id: {}", id);
    }

}
