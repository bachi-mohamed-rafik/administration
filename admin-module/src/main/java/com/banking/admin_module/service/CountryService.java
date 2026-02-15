package com.banking.admin_module.service;

import com.banking.admin_module.mapper.CountryMapper;
import com.banking.admin_module.model.dto.Country.request.CreateCountryRequest;
import com.banking.admin_module.model.dto.Country.request.UpdateCountryRequest;
import com.banking.admin_module.model.dto.Country.response.CountryResponse;
import com.banking.admin_module.model.entity.Country;
import com.banking.admin_module.repository.CountryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public interface CountryService {

        // get all countries
        public List<CountryResponse> getAllCountries();

        //get country by id
        public CountryResponse getCountryById(Long id);

        // create a country
        public CountryResponse createCountry(CreateCountryRequest request);

        //update a country
        public CountryResponse updateCountry(Long id, UpdateCountryRequest updatedCountry);

        @Transactional
        public void deleteCountry(Long id);
}
