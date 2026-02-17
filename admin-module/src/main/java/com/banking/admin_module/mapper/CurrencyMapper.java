package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.Currency.request.CreateCurrencyRequest;
import com.banking.admin_module.model.dto.Currency.request.UpdateCurrencyRequest;
import com.banking.admin_module.model.entity.Currency;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import com.banking.admin_module.model.dto.Currency.response.CurrencyResponse;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    @Mapping(target = "id", ignore = true)
    Currency toEntity(CreateCurrencyRequest request);

    void updateEntity(UpdateCurrencyRequest request, @MappingTarget Currency currency);

    @Mapping(target = "id", source = "id")
    CurrencyResponse toResponse(Currency currency);

    List<CurrencyResponse> toResponseList(List<Currency> currencies);
}
