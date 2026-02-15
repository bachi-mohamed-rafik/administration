package com.banking.admin_module.model.dto.Currency.response;

public record CurrencyResponse(
        Long id,
        String name,
        String code,
        String symbol
) {
}
