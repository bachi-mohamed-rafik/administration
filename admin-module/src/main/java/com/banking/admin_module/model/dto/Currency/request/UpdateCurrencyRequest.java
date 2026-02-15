package com.banking.admin_module.model.dto.Currency.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record UpdateCurrencyRequest(
        @Schema(description = "Updated currency name", example = "Algerian Dinar")
        @NotBlank(message = "Currency name is required")
        String name,

        @Schema(description = "Updated currency code", example = "DA")
        @NotBlank(message = "Code is required")
        String code,

        @Schema(description = "Updated currency symbol", example = "DA")
        @NotBlank(message = "Symbol is required")
        String symbol

) {
}
