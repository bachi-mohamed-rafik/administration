package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.Country;
import com.banking.admin_module.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService {
    private final CountryRepository countryRepository;
    public CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }
    // get all countries
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    //get country by id
    public Country getCountryById(Long id){
        Country foundCountry;
        return countryRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("dont exists"));
    }

    // create a country
    public Country createCountry(Country country){
        return countryRepository.save(country);
    }

    //update a country
    public Country updateCountry(Long id, Country updatedCountry){
        Country existingCountry = countryRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("country didnt exists"));
        if (updatedCountry.getName()!= null){
            existingCountry.setName(updatedCountry.getName());
        }
        if (updatedCountry.getCode()!= null){
            existingCountry.setCode(updatedCountry.getCode());
        }
        if (updatedCountry.getRegion()!= null){
            existingCountry.setRegion(updatedCountry.getRegion());
        }
        return countryRepository.save(existingCountry);
    }
}
