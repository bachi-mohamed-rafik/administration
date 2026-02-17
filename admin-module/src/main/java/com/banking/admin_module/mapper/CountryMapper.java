package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.Country.request.CreateCountryRequest;
import com.banking.admin_module.model.dto.Country.request.UpdateCountryRequest;
import com.banking.admin_module.model.dto.Country.response.CountryResponse;
import com.banking.admin_module.model.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mapping(target = "id", ignore = true)
    Country toEntity(CreateCountryRequest request);

    @Mapping(target = "id", ignore = true)
    void updateEntity(UpdateCountryRequest request, @MappingTarget Country country);

    @Mapping(target = "id", source = "id")
    CountryResponse toResponse(Country country);

    List<CountryResponse> toResponseList(List<Country> countries);
}
