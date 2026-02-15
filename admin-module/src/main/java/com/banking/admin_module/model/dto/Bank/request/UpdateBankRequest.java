package com.banking.admin_module.model.dto.Bank.request;

import com.banking.admin_module.model.entity.BfsiGroup;
import com.banking.admin_module.model.entity.Country;
import com.banking.admin_module.model.entity.Currency;
import com.banking.admin_module.model.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request DTO pour la mise à jour d'une banque")
public record UpdateBankRequest(
        @Schema(description = "Le nom de la banque", example = "Banque Nationale d'Algérie")
        @NotNull(message = "Le nom de la banque est obligatoire")
        String name,

        @Schema(description = "Le code de la banque", example = "BNA")
        String code,

        @Schema(description = "La description de la banque", example = "123 Rue de la Banque, Alger")
        String description,

        @NotNull
        @Schema(description = "La monnaie utilisé dans cette banque", example = ") " +"")
        Currency currency,

        @Schema(description = "Le pays où la banque est située", example = "Algérie")
        Country country,

        @Schema(description = "Indique si la compensation nette est autorisée pour cette banque", example = "true")
        Boolean nettingAllowedFlag,

        @NotNull
        @Schema(description = "Le groupe BFSI auquel appartient la banque")
        BfsiGroup bfsiGroup,

        @Schema(description = "Le statut de la banque", example = "ACTIVE")
        Status status,

        @Schema(description = "Le nom local de la banque", example = "بنك الجزائر الوطني")
        String nameLocal,

        @Schema(description = "Le logo de la banque", example = "ب.ج.ا")
        String logo
) {
}
