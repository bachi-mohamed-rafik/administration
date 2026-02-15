package com.banking.admin_module.model.dto.Bank.request;

import com.banking.admin_module.model.entity.BfsiGroup;
import com.banking.admin_module.model.entity.Currency;
import com.banking.admin_module.model.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(
        name = "CreateBankRequest",
        description = "Request DTO pour la création d'une banque"
)
public record CreateBankRequest(
        @Schema(description = "Le nom de la banque", example = "Banque Nationale d'Algérie")
        @NotNull(message = "Le nom de la banque est obligatoire")
        String name,

        @Schema(description = "Le code de la banque", example = "BNA")
        String code,

        @Schema(description = "La description de la banque", example = "123 Rue de la Banque, Alger")
        String description,

        @NotNull(message = "Country ID est obligatoire")
        @Schema(description = "L'identifiant du pays où la banque est située", example = "1")
        Long countryId,

        @NotNull
        @Schema(description = "La monnaie utilisé dans cette banque", example = ") " +"")
        Long currencyId,

        @NotNull(message = "nettingAllowedFlag est obligatoire")
        @Schema(description = "Indique si la compensation nette est autorisée pour cette banque", example = "true")
        Boolean nettingAllowedFlag,

        @NotNull(message = "settlementAllowedFlag est obligatoire")
        @Schema(description = "Le groupe BFSI auquel appartient la banque")
        Long bfsiGroupId,

        @NotNull(message = "status est obligatoire")
        @Schema(description = "Le statut de la banque", example = "ACTIVE")
        Status status,

        @Schema(description = "Le nom local de la banque", example = "بنك الجزائر الوطني")
        String nameLocal,

        @Schema(description = "Le logo de la banque", example = "ب.ج.ا")
        String logo
){
}
