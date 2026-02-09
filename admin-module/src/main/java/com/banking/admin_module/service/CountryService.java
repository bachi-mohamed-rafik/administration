package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.Country;
import com.banking.admin_module.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class CountryService {
    private final CountryRepository countryRepository;

    // get all countries
    public List<Country> getAllCountries(){
        log.debug("Fetching all countries");
        return countryRepository.findAll();
    }

    //get country by id
    public Country getCountryById(Long id){
        Country foundCountry;
        log.debug("Fetching country with id {}", id);
        return countryRepository.findById(id)
                .orElseThrow(() ->{
                log.error("Country with id {} not found", id);
                    return new RuntimeException("dont exists");
                });
    }

    // create a country
    public Country createCountry(Country country){
        log.debug("Creating new country with name {}", country.getName());
        return countryRepository.save(country);
    }

    //update a country
    public Country updateCountry(Long id, Country updatedCountry){
        Country existingCountry = countryRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Country with id {} not found for update", id);
                    return new RuntimeException("country didnt exists");
                });
        if (updatedCountry.getName()!= null){
            existingCountry.setName(updatedCountry.getName());
        }
        if (updatedCountry.getCode()!= null){
            existingCountry.setCode(updatedCountry.getCode());
        }
        if (updatedCountry.getRegion()!= null){
            existingCountry.setRegion(updatedCountry.getRegion());
        }
        log.debug("Updating country with id {}", id);
        return countryRepository.save(existingCountry);
    }
}
