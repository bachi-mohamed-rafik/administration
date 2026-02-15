package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.Currency.request.CreateCurrencyRequest;
import com.banking.admin_module.model.entity.Currency;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import com.banking.admin_module.model.dto.Currency.response.CurrencyResponse;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    @Mapping(target = "id", ignore = true)
    Currency toEntity(CreateCurrencyRequest request);

    CurrencyResponse updateEntity(Currency currency);

    CurrencyResponse toResponse(Currency currency);
}
