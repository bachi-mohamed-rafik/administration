package com.banking.admin_module.service.Impl;

import com.banking.admin_module.mapper.CountryMapper;
import com.banking.admin_module.model.dto.Country.request.CreateCountryRequest;
import com.banking.admin_module.model.dto.Country.request.UpdateCountryRequest;
import com.banking.admin_module.model.dto.Country.response.CountryResponse;
import com.banking.admin_module.model.entity.Country;
import com.banking.admin_module.repository.CountryRepository;
import com.banking.admin_module.service.CountryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper mapper;

    // get all countries
    public List<CountryResponse> getAllCountries(){
        log.debug("Fetching all countries");
        return countryRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    //get country by id
    public CountryResponse getCountryById(Long id){
        Country foundCountry;
        log.debug("Fetching country with id {}", id);
        Country country= countryRepository.findById(id)
                .orElseThrow(() ->{
                    log.error("Country with id {} not found", id);
                    return new RuntimeException("dont exists");
                });
        return mapper.toResponse(country);
    }

    // create a country
    public CountryResponse createCountry(CreateCountryRequest request){
        log.debug("Creating new country with name {}", request.name());
        Country country = mapper.toEntity(request);
        Country savedCountry = countryRepository.save(country);

        return mapper.toResponse(savedCountry);
    }

    //update a country
    public CountryResponse updateCountry(Long id, UpdateCountryRequest updatedCountry){
        Country existingCountry = countryRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Country with id {} not found for update", id);
                    return new RuntimeException("country didnt exists");
                });
        if (updatedCountry.name() != null){
            existingCountry.setName(updatedCountry.name());
        }
        if (updatedCountry.region() != null){
            existingCountry.setRegion(updatedCountry.region());
        }
        Country updated = countryRepository.save(existingCountry);
        log.debug("Updating country with id {}", id);
        return mapper.toResponse(updated);
    }

    @Transactional
    public void deleteCountry(Long id){
        log.debug("Deleting country with id {}", id);
        if (!countryRepository.existsById(id)){
            log.error("Country with id {} not found for deletion", id);
            throw new RuntimeException("country didnt exists");
        }
        countryRepository.deleteById(id);
    }

}
