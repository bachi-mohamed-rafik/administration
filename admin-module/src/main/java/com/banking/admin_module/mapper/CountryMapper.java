package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.Country.request.CreateCountryRequest;
import com.banking.admin_module.model.dto.Country.request.UpdateCountryRequest;
import com.banking.admin_module.model.dto.Country.response.CountryResponse;
import com.banking.admin_module.model.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "banks", ignore = true)  // Don't set banks on creation
    Country toEntity(CreateCountryRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "code", ignore = true)  // Don't update code
    @Mapping(target = "name", ignore = true)
    CountryResponse updateEntity(UpdateCountryRequest request);

    CountryResponse toResponse(Country country);
}
