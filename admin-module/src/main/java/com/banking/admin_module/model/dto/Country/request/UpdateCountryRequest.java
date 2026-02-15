package com.banking.admin_module.model.dto.Country.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Request to update an existing country")
public record UpdateCountryRequest(

        @Schema(description = "Updated country name", example = "Algeria")
        @NotBlank(message = "Country name is required")
        String name,

        @Schema(description = "Updated geographic region", example = "North Africa")
        @NotBlank(message = "Region is required")
        String region

        // Note: code is usually NOT updated (it's a unique identifier)
) {
}
