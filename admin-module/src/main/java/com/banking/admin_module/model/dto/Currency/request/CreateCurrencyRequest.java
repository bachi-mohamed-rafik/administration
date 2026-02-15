package com.banking.admin_module.model.dto.Currency.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record CreateCurrencyRequest(
        @Schema(description = "Le nom du monnaie", example = "Dinadr algérien")
        @NotNull(message = "Le nom du monnaie est obligatoire")
        String name,

        @Schema(description = "Le code du monnaie", example = "DZD")
        @NotNull(message = "Le code la monniae est obligatoire")
        String code,

        @Schema(description = "Le symbole du monnaie", example = "DA")
        @NotNull(message = "Le symbole est obligatoire")
        String symbol

) {
}
