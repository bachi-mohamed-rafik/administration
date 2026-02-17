package com.banking.admin_module.model.dto.Country.response;

public record CountryResponse(
        Long id,
        String code,
        String region,
        String name
) {
}
