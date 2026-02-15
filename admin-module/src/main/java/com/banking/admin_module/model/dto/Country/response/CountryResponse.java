package com.banking.admin_module.model.dto.Country.response;

public record CountryResponse(
        Long id,
        String name,
        String code,
        String region
) {
}
