package com.banking.admin_module.model.dto.Country.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request to update an existing country")
public record UpdateCountryRequest(

        @Schema(description = "Le code ISO du pays", example = "DZ")
        @NotNull(message = "Le code ISO du pays est obligatoire")
        String code,

        @Schema(description = "La région du pays", example = "Afrique du Nord")
        @NotNull(message = "La région du pays est obligatoire")
        String region,

        @Schema(description = "Le nom du pays", example = "Algérie")
        @NotNull(message = "Le nom du pays est obligatoire")
        String name
) {
}
