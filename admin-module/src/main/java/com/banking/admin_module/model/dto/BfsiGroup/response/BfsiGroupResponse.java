package com.banking.admin_module.model.dto.BfsiGroup.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response DTO pour les opérations liées au groupe BFSI")
public record BfsiGroupResponse(

        @Schema(description = "ID du groupe BFSI", example = "1")
        Long id,

        @Schema(description = "Nom du groupe BFSI", example = "Groupe A")
        String name,

        @Schema(description = "Description du groupe BFSI", example = "Ce groupe regroupe les clients VIP")
        String description,

        @Schema(description = "Nombre de banks dans le groupe BFSI", example = "150")
        int bankCount
) {
}
