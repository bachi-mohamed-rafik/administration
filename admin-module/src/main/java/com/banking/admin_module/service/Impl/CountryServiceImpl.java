package com.banking.admin_module.service.Impl;

import com.banking.admin_module.exception.ResourceAlreadyExistsException;
import com.banking.admin_module.mapper.CountryMapper;
import com.banking.admin_module.model.dto.Country.request.CreateCountryRequest;
import com.banking.admin_module.model.dto.Country.request.UpdateCountryRequest;
import com.banking.admin_module.model.dto.Country.response.CountryResponse;
import com.banking.admin_module.model.entity.Country;
import com.banking.admin_module.repository.CountryRepository;
import com.banking.admin_module.service.CountryService;
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
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper mapper;

    // get all countries
    @Override
    public List<CountryResponse> getAllCountries(){
        log.debug("Fetching all countries");
        List<Country> countries = countryRepository.findAll();
        log.debug("Fetched {} countries", countries.size());
        return  mapper.toResponseList(countries);
    }

    //get country by id
    @Override
    public CountryResponse getCountryById(Long id){
        log.debug("Fetching country with id {}", id);
        Country country= countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Country with id %d not found", id)
                        ));
        log.info("Fetched country: {}", country.getName());
        return mapper.toResponse(country);
    }

    // create a country
    @Override
    @Transactional
    public CountryResponse createCountry(CreateCountryRequest request){
        log.debug("Creating new country with name {}", request.name());

        if(countryRepository.existsByCode(request.code())){
            log.error("Country with id {} already exists", request.code());
            throw new ResourceAlreadyExistsException(
                    String.format("Country with code %s already exists", request.code())
            );
        }
        Country country = mapper.toEntity(request);
        Country savedCountry = countryRepository.save(country);

        log.debug("Created country with id {}", savedCountry.getId());
        return mapper.toResponse(savedCountry);
    }

    //update a country
    @Override
    public CountryResponse updateCountry(Long id, UpdateCountryRequest request){
        log.info("Updating country with id {}", id);

        Country existingCountry = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                            String.format("Country with id %d not found for update", id)
                    ));
        if (request.name() != null){
            existingCountry.setName(request.name());
        }
        if (request.region() != null){
            existingCountry.setRegion(request.region());
        }
        if (request.code() != null){
            existingCountry.setCode(request.code());
        }
        Country updated = countryRepository.save(existingCountry);
        CountryResponse updatedResponse =mapper.toResponse(updated);
        log.debug("Updating country with id {}", id);
        return updatedResponse;
    }

    @Transactional
    @Override
    public void deleteCountry(Long id){
        log.debug("Deleting country with id {}", id);
        Country existingCountry = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Country with id %d not found for deletion", id)
                ));
        countryRepository.delete(existingCountry);
        log.debug("Deleted country with id {}", id);
    }

}
