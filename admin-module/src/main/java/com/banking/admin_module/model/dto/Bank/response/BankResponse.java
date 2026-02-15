package com.banking.admin_module.model.dto.Bank.response;

import com.banking.admin_module.model.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response DTO pour les opérations liées à la banque")
public record BankResponse(

        @Schema(description = "ID de la banque")
        Long id,

        @Schema(description = "Le nom de la banque", example = "Banque Nationale d'Algérie")
        String name,

        @Schema(description = "Le code de la banque", example = "BNA")
        String code,

        @Schema(description = "La description de la banque", example = "123 Rue de la Banque, Alger")
        String description,

        // Country ID pour éviter les problèmes de sérialisation avec l'entité Country
        @Schema(description = "L'identifiant du pays où la banque est située", example = "1")
        Long countryId,
        String countryName,

        @Schema(description = "La monnaie utilisé dans cette banque")
        Long currencyId,
        String currencyName,
        String currencyCode,

        @Schema(description = "Indique si la compensation nette est autorisée pour cette banque", example = "true")
        Boolean nettingAllowedFlag,

        @Schema(description = "Le groupe BFSI auquel appartient la banque")
        Long bfsiGroupId,

        @Schema(description = "Le statut de la banque", example = "ACTIVE")
        Status status,

        @Schema(description = "Le nom local de la banque", example = "بنك الجزائر الوطني")
        String nameLocal,

        @Schema(description = "Le logo de la banque", example = "ب.ج.ا")
        String logo

) {
}
