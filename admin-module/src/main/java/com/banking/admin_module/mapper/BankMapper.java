package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.Bank.request.CreateBankRequest;
import com.banking.admin_module.model.dto.Bank.request.UpdateBankRequest;
import com.banking.admin_module.model.dto.Bank.response.BankResponse;
import com.banking.admin_module.model.entity.Bank;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BankMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "currency", ignore = true)
    @Mapping(target = "bfsiGroup", ignore = true)
    Bank toEntity(CreateBankRequest createBankRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "currency", ignore = true)
    @Mapping(target = "bfsiGroup", ignore = true)
    void updateEntity(UpdateBankRequest updateBankRequest, @MappingTarget Bank bank);

    @Mapping(source = "bfsiGroup.id", target = "bfsiGroupId")
    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.name", target = "countryName")
    @Mapping(source = "currency.id", target = "currencyId")
    @Mapping(source = "currency.code", target = "currencyCode")
    @Mapping(source = "currency.name", target = "currencyName")
    BankResponse toResponse(Bank bank);
}
