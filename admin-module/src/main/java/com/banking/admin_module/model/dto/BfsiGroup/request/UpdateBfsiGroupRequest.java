package com.banking.admin_module.model.dto.BfsiGroup.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Request DTO pour la mise à jour d'un groupe BFSI")
public record UpdateBfsiGroupRequest(

        @Schema(description = "Le nom du groupe BFSI", example = "Groupe BFSI 1")
        @NotBlank(message = "Le nom du groupe BFSI ne peut pas être vide")
        String name,

        @Schema(description = "La description du groupe BFSI", example = "Description du groupe BFSI 1")
        String description
) {
}
